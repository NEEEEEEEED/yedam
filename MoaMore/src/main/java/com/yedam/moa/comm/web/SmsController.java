package com.yedam.moa.comm.web;
 
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yedam.moa.comm.service.SmsService;
import com.yedam.moa.mem.MessageDTO;
import com.yedam.moa.mem.SmsResponseDTO;

import lombok.RequiredArgsConstructor;
 
@Controller
@RequiredArgsConstructor
public class SmsController {
	
	private final SmsService smsService;
	
	@GetMapping("/send")
	public String getSmsPage() {
		return "sendSms";
	};
	
	@PostMapping("/sms/send")
	@ResponseBody
	public SmsResponseDTO sendSms(@RequestBody MessageDTO messageDto) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(messageDto);
		SmsResponseDTO response = smsService.sendSms(messageDto);
		return response;
	};
 
	
}