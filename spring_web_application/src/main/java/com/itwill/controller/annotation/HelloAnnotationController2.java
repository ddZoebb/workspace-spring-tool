package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloAnnotationController2 {
	
	public HelloAnnotationController2() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(HttpServletRequest request) {
		request.setAttribute("msg", "HelloAnnotationController2");
		return "forward:/WEB-INF/views/hello2.jsp";
	}

}
