package com.luckyun.demo;

import java.util.Collections;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * 基础测试类
 * @author omai
 *
 */
public class BaseTest {

	@Autowired
	public TestRestTemplate testRestTemplate;
	
	@Before()
	public void auth() {
		testRestTemplate.getRestTemplate().setInterceptors(
		        Collections.singletonList((request, body, execution) -> {
		            request.getHeaders()
		                    .add("AuthInfo", "eyJpbmRvY25vIjoyLCJzbG9naW5pZCI6ImFkbWluIiwic3Bhc3N3b3JkIjoiZTEwYWRjMzk0OWJhNTlhYmJlNTZlMDU3ZjIwZjg4M2UiLCJzbmFtZSI6IueuoeeQhuWRmCIsImlzdGF0ZSI6MSwicm9sZUxpc3QiOlt7ImtleUluZG9jbm8iOjIsImluZG9jbm8iOjIsInNyZWdpZCI6MiwiZHJlZ3QiOiIyMDE5LTAxLTAyIDExOjM3OjExIiwiaWRlbCI6MCwiaXR5cGVpZCI6Miwic25hbWUiOiLnrqHnkIblkZgiLCJzZGVzY3JpYmUiOiLmiYDmnInnmoTmk43kvZzmnYPpmZDlkozlrqHmibnmnYPpmZAiLCJpc3RhdGUiOjEsImlzb3J0IjoyLCJpbGV2ZWwiOjV9XSwiZGVwdExpc3QiOlt7ImtleUluZG9jbm8iOjEwMDEsImluZG9jbm8iOjEwMDEsImRyZWd0IjoiMjAxOS0wNy0xNyAxMDozNzowMyIsImlkZWwiOjAsInNuYW1lIjoi5b6F5bKX5py65p6EIiwiaXR5cGUiOjAsImNvbXBhbnlOYW1lIjoi5aSn6L+e5Z+65ZywIiwiaWNvbXBhbnlpZCI6MX1dLCJvcGVyYXRlTGlzdHMiOiIifQ==");
		            return execution.execute(request, body);
		        }));
	}
}
