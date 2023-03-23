package com.yedam.spring.user.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.user.service.UserVO;

//데이터를 반환하는 컨트롤러
//CORS Web개발자가 숙명처럼 여기는 에러를 처리해줌
@CrossOrigin
@RestController
public class UserRestController {
		//get 방식으로 요청시 405에러 발생 -> post 방식으로 요청해야함
		@RequestMapping(value="/insertUser", method=RequestMethod.POST)
		public UserVO insertUser(UserVO userVO) {
			
			System.out.println("name : " + userVO.getName());
			System.out.println("age : " + userVO.getAge());
			
			return userVO;
		}
}
