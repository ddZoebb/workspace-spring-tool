package com.itwill.guest;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoImpJdbcTemplateTestMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/guest_dao_jdbc_template.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		
		GuestDao guestDao=(GuestDao)applicationContext.getBean(GuestDao.class);
		System.out.println(guestDao);
		System.out.println(guestDao.selectAll());
		System.out.println(guestDao.insertGuest(new Guest(0, "차운우", null, "cha@email.co,", "homepage", "title", "content")));
		System.out.println(guestDao.updateGuest(new Guest(8, "업데", null, "update", "update", "test", "test")));
		System.out.println(guestDao.deleteGuest(8));
	}

}
