package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.GuestService;

public class GuestErrorController implements Controller {
	private GuestService guestService;
	
	public GuestErrorController() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		ModelAndView mv=new ModelAndView(forwardPath);
		return mv;
	}

}
