package com.itwill.guest;

public class GuestDaoMyBatisTestMain {

	public static void main(String[] args) throws Exception{
		GuestDaoMyBatis guestDaoMyBatis=new GuestDaoMyBatis();
		System.out.println("----selectAll---");
		//guestDaoMyBatis.selectAll();
		
		System.out.println("insert");
		//System.out.println(guestDaoMyBatis.insertGuest(new Guest(0,"인서트", null, "insert@naver.cim", "insert.co.kr","인서트", "테스트")));
		
		System.out.println("select");
		System.out.println(guestDaoMyBatis.selectByNo(5));
		
		System.out.println("selectAll");
		System.out.println(guestDaoMyBatis.selectAll());
		
		System.out.println("delete");
		System.out.println(guestDaoMyBatis.deleteGuest(45));
		
		System.out.println("update");
		System.out.println(guestDaoMyBatis.updateGuest(new Guest(48,"변경",null,"update","update","update","update")));
	}

}
