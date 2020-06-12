package com.luckyun.demo.base.mq;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.luckyun.core.mq.BaseQueue;
import com.luckyun.demo.base.entity.SysUser;

@Component
public class TestQueue extends BaseQueue<SysUser> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void onMessage(SysUser message) throws Exception {
		logger.info("onMessage：" + message);
		throw new Exception("err");
	}
	
	
	///
	/// 下面的方法没有特殊的情况无需覆盖，特殊的情况根据具体的场景自定义
	///
	
	/**
	 * 	框架默认是开启延时处理的，如果某些任务具有较高的实时性，可以覆盖上面的方法，取消延时处理。
	 */
    @Override
    protected boolean isRetry() {
    	return super.isRetry();
    }
    
    /**
     * 	覆盖这个方法可以设置消息的超时时间，如果超过这个时间还未处理，消息就会自动进入死信队列
     */
	@Override
	protected int getMessageTTL() {
		// TODO Auto-generated method stub
		return super.getMessageTTL();
	}


	/**
	 *	有的时候我们只希望在当前服务中定义队列，而不进行消费，可以让性能更好的服务器去消费一些比较耗资源的任务，那么我们就可以通过覆盖上面的方法实现
	 */
	@Override
	protected boolean isStartListening() {
		// TODO Auto-generated method stub
		return super.isStartListening();
	}

    /**
     * 	如果返回`true`，那么当该队列所有的连接断开时，系统会自动删除该队列
     */
	@Override
	protected boolean isAutoDelete() {
		// TODO Auto-generated method stub
		return super.isAutoDelete();
	}

    /**
     * 	默认框架都开启了`ACK模式`，也就是说消息消费并确认了才会取下一条，为了保证并发性，框架默认只从队列中取一条消息进行消费，
     * 	如果业务对并发性没有要求，那么可以通过覆盖上面的方法，一次性获得更多的消息数量来提升消费速度
     */
	@Override
	protected int getPrefetchCount() {
		// TODO Auto-generated method stub
		return super.getPrefetchCount();
	}


	/**
	 *	进入死信容错队列的消息，默认10分钟会尝试重新消费一次，可以通过覆盖上面的方法自定义重试时间。
	 */
	@Override
	protected int getRetryTime() {
		return 1000 * 60;
	}

	/**
	 *	 有的时候我们不希望消息进入死信容错队列以后就无限重试下去，比如我们处理的是一个发通知的消息，但是通知类型的消息都具有实效性的，超过一定时间的通知是没有意义的，还会给用户造成误解
	 *	所以我们同样可以给死信容错队列里的消息设置过期时间，如果超时还未处理，消息就会永久丢弃了
	 *	默认返回`0`，代表永不过期
	 */
	@Override
	protected int getDeadMessageTTL() {
		return 30000;
	}
	
	/**
	 *	分布式微服务`架构下，如果同一个服务启动了多个实例实现负载均衡，那么每个服务实例默认都会启动一个消费者，要想保证消息队列的并发性，我们可以覆盖上面的方法，
	 *	实现只在其中一个服务启用消费者监听，其余的服务只是定义了该队列
	 */
	@Override
	protected boolean isSingleConsumer() {
		return true;
	}
	
	/**
	 *	 可以通过上面的方法自定义队列的参数，具体参数参考标准`AMQP`协议`Arguments`清单
	 */
	@Override
	protected Map<String, Object> getArgs() {
		Map<String, Object> args = super.getArgs();
		// args.put("myKey", "myValue");
		return args;
	}
	

	/**
	 *	 可以通过上面的方法自定义死信队列的参数，具体参数参考标准`AMQP`协议`Arguments`清单
	 */
	@Override
	protected Map<String, Object> getDeadArgs() {
		// TODO Auto-generated method stub
		return super.getDeadArgs();
	}


	/**
	 * Scheduled Queue 定时队列
	 * 
	 * @Scheduled(cron="0 0/1 * * * ?") public void testTasks() {
	 *                    logger.info("cron表达式，每1分钟执行一次。开始……"); this.sendMessage(new
	 *                    User()); }
	 */

}
