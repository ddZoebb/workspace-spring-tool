package com.itwill2.bean.di;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.user.UserService;

public class SpringApplicationContextConstructorInjectionMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("2.bean_constructor_injection.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
	
		GuestService guestService=
				(GuestService)applicationContext.getBean(GuestService.class);
		
		/*
		 * GuestService guestService2=
		 * (GuestService)applicationContext.getBean("com.itwill.guest.GuestService");
		 */
		
		System.out.println(guestService.selectAll());
		
		System.out.println("--기본형 데이터 constructor injection");
		Guest guest=(Guest)applicationContext.getBean(Guest.class);
		System.out.println(guest);
		
		/***reflection api***/
		Class guestClass=GuestService.class;
		Class guestClass2=Class.forName("com.itwill.guest.GuestService");
		
		String className=guestClass.getName();
		System.out.println(className);
		Method[] methods=guestClass2.getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method);
		}
	}

}
