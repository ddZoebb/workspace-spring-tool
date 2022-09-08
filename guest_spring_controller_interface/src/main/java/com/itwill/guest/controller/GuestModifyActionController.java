package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestModifyActionController implements Controller {
	private GuestService guestService;

	public GuestModifyActionController() {
		System.out.println("### GuestModifyActionController()생성자 호출");
	}

	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestModifyActionController : setGuestService(" + guestService + ") 메쏘드 호출");
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		
		try {
			Guest guest=new Guest(Integer.parseInt(request.getParameter("guest_no")), request.getParameter("guest_name"), 
					request.getParameter("guest_date"), request.getParameter("guest_email"), 
					request.getParameter("guest_homepage"), request.getParameter("guest_title"), 
					request.getParameter("guest_content"));
			guestService.updateGuest(guest);
			forwardPath="redirect:guest_view.do?guest_no=" + request.getParameter("guest_no");

		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			
		}
		ModelAndView mv = new ModelAndView(forwardPath);
		return mv;

	}

}
