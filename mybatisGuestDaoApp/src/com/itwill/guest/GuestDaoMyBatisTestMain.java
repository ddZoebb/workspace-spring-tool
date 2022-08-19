package com.itwill.guest;

public class GuestDaoMyBatisTestMain {

	public static void main(String[] args) throws Exception{
		GuestDaoMyBatis guestDaoMyBatis=new GuestDaoMyBatis();
		System.out.println("----selectAll---");
		guestDaoMyBatis.selectAll();
	}

}
