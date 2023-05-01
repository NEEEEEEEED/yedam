package com.yedam.moa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class WebControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void mainLoading() { 
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
	}
}
