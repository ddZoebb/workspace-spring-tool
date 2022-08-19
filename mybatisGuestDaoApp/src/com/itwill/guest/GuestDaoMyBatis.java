package com.itwill.guest;

import java.util.List;

/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME     NOT NULL VARCHAR2(10)   
GUEST_DATE     NOT NULL DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE    NOT NULL VARCHAR2(100)  
GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
 */

public class GuestDaoMyBatis {

	public GuestDaoMyBatis() {

	}

	public int insertGuest(Guest guest) throws Exception {

		return 0;
	}

	public Guest selectByNo(int no) throws Exception {
		Guest guest = null;

		return guest;
	}

	public List<Guest> selectAll() throws Exception {
		List<Guest> guestList = null;

		return guestList;
	}

	public int updateGuest(Guest guest) throws Exception {

		return 0;
	}

	public int deleteGuest(int no) throws Exception {

		return 0;
	}
}
