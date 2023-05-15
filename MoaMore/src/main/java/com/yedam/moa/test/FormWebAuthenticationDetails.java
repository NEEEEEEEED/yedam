package com.yedam.moa.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class FormWebAuthenticationDetails extends WebAuthenticationDetails {
    private String userKey;

    // 사용자가 전달하는 추가적인 파라미터들을 저장하는 클래스
    public FormWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        userKey =  request.getParameter("user_key");
    }

    public String getUserKey() {
        return userKey;
    }
}
