package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestRemoveActionController implements Controller {
	private GuestService guestService;

	public GuestRemoveActionController() {
		System.out.println("### GuestRemoveActionController()생성자 호출");
	}

	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestRemoveActionController : setGuestService(" + guestService + ") 메쏘드 호출");
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {
			guestService.deleteGuest(Integer.parseInt(request.getParameter("guest_no")));
			forwardPath = "redirect:guest_list.do";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";

		}
		ModelAndView mv = new ModelAndView(forwardPath);
		return mv;
	}

}
