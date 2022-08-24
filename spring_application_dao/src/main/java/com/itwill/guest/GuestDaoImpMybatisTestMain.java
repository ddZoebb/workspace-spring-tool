package com.itwill.guest;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoImpMybatisTestMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/guest_dao_mybatis.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		GuestDao guestDao=(GuestDao)applicationContext.getBean(GuestDao.class);
		
		System.out.println(guestDao.selectAll());
		System.out.println(guestDao.selectByNo(22));
		System.out.println(guestDao.deleteGuest(22));
		Guest guest=new Guest(0, "롯데리아", null, "Lotte@", "lotte", "롯데리아", "뭐먹지");
		System.out.println(guestDao.insertGuest(guest));
		System.out.println(guestDao.updateGuest(new Guest(41, "김변경", null, "update", "homepage", "title", "content")));
		System.out.println(guestDao.selectByNo(41));
	}

}
