package com.luckyun.demo.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckyun.core.data.BaseMapper;
import com.luckyun.core.data.BaseService;
import com.luckyun.demo.base.entity.DocTest;
import com.luckyun.demo.base.mapper.DocTestMapper;

@Service
public class DocTestService extends BaseService<DocTest> {
	
	@Autowired
	DocTestMapper docTestMapper;

	@Override
	public BaseMapper<DocTest> getMapper() {
		// TODO Auto-generated method stub
		return docTestMapper;
	}
	
	/**
	 * 读取
	 * @param id
	 * @return
	 */
	public DocTest readOne(Long id) {
		DocTest docTest = new DocTest();
		docTest.setIndocno(id);
		return docTestMapper.select(docTest);
	}
	
	/**
	 * 添加
	 * @param account
	 * @return
	 */
	public int Add(DocTest docTest) {
		int re = this.insert(docTest);
		return re;
	}
	
	/**
	 * 更新
	 * @return
	 */
	public int updateAccount(DocTest docTest) {
		return this.update(docTest);
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteDoc(Long id) {
		DocTest docTest = new DocTest();
		docTest.setIndocno(id);
		return this.delete(docTest);
	}

}
