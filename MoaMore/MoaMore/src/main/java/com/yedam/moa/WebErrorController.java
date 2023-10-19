package com.yedam.moa;

import org.springframework.boot.web.servlet.error.ErrorController;

//@Controller
public class WebErrorController implements ErrorController {
   // @GetMapping("/error")
    public String redirctRoot() {
        return "error";
    }

	/*
	 * public String getErrorPath() { return "/error"; }
	 */
}
