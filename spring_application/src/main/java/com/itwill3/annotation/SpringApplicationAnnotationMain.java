package com.itwill3.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.GuestService;
import com.itwill.user.UserService;

public class SpringApplicationAnnotationMain {

	public static void main(String[] args) {
		
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("1.bean_create_annotation.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		
		  System.out.println("--scope : singleton--"); GuestService
		  guestService1=(GuestService)applicationContext.getBean("guestService");
		  GuestService
		  guestService2=(GuestService)applicationContext.getBean("guestService");
		  
		  System.out.println("--scope : prototype--"); UserService
		  userService1=(UserService)applicationContext.getBean("userService");
		  UserService
		  userService2=(UserService)applicationContext.getBean("userService");
		  System.out.println("--Container 에 있는 모든 빈 객체 참조 얻기");
		  System.out.println(applicationContext.getBean("dataSource"));
		  System.out.println(applicationContext.getBean("guestDao"));
		  System.out.println(applicationContext.getBean("userDao"));
		  System.out.println(applicationContext.getBean("guestService"));
		  System.out.println(applicationContext.getBean("userService"));
		 
	}

}
