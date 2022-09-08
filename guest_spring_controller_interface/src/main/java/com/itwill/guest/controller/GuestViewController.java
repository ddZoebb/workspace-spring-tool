package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestViewController implements Controller {
	private GuestService guestService;

	public GuestViewController() {
		System.out.println("### GuestViewController()생성자 호출");
	}

	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestViewController : setGuestService(" + guestService + ") 메쏘드 호출");
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {

			Guest guest = guestService.selectByNo(Integer.parseInt(request.getParameter("guest_no")));
			request.setAttribute("guest", guest);
			forwardPath="forward:/WEB-INF/views/guest_view.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";

		}
		ModelAndView mv = new ModelAndView(forwardPath);
		return mv;
	}

}
