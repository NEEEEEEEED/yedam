package com.yedam.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;

//junit에서 컨테이너 만들기
@RunWith(SpringJUnit4ClassRunner.class)
//src/test/java는 독립적 공간 컨테이너를 자동으로 생성 x
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestClass {
	
	//구현 클래스는 사용할때 타입을 인터페이스를 사용
	//즉 @Autowired 밑에 인터페이스가 와야함
//	@Autowired
//	ApplicationContext ctx;
	
	@Autowired
	Restaurant res;
	
	@Test
	public void beanTest() {
		//							 클래스에 대한 정보
//		Restaurant res = ctx.getBean(Restaurant.class);
		assertNotNull(res);
	}
}
