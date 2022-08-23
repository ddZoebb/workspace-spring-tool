package com.itwill.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.GuestService;

public class GuestServiceSpringApplicationTestMain  {
	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/test/guest_service_spring_application.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		GuestService guestService=(GuestService)applicationContext.getBean("guestService");
		System.out.println("GuestService.selectAll");
		System.out.println(guestService.selectAll());
		System.out.println("selectbyNo");
		System.out.println(guestService.selectByNo(6));
	
	}

}
