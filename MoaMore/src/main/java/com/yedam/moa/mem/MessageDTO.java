package com.yedam.moa.mem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MessageDTO {
	String to ;
	String subject = "개인인증";
	String content;
}
