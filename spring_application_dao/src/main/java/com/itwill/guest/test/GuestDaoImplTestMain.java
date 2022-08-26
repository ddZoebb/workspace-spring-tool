package com.itwill.guest.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoImplTestMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/guest_dao_jdbc.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		GuestDao guestDao=
				(GuestDao)applicationContext.getBean(GuestDao.class);
		
		System.out.println("### GuestDao.selectAll():"+guestDao.selectAll());
		Guest guest=guestDao.selectByNo(222);
		System.out.println("### GuestDao.selectByNo(222):"+guest);
		guest.setGuest_name("쭌우운~~");
		guest.setGuest_title("오늘은 수요일 타이틀");
		System.out.println("### GuestDao.updateGuest():"+guestDao.updateGuest(guest));
		guest=guestDao.selectByNo(222);
		System.out.println(guest);
	}

}
