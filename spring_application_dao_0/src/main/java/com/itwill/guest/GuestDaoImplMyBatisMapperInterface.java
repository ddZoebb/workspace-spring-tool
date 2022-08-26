package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.guest.mapper.GuestMapper;

@Repository
public class GuestDaoImplMyBatisMapperInterface implements GuestDao{
	@Autowired
	private GuestMapper guestMapper;
	public GuestDaoImplMyBatisMapperInterface() {
		System.out.println("#### GuestDaoImplMyBatisMapperInterface()기본생성자");
	}
	
	
	public void setGuestMapper(GuestMapper guestMapper) {
		System.out.println("#### GuestDaoImplMyBatisMapperInterface: setGuestMapper ("+guestMapper+")호출");
		this.guestMapper = guestMapper;
	}


	@Override
	public List<Guest> selectAll() throws Exception {
		return guestMapper.selectAll();
	}
	@Override
	public Guest selectByNo(int no) throws Exception {
		return guestMapper.selectByNo(no);
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		return guestMapper.insertGuest(guest);
	}
	@Override
	public int updateGuest(Guest guest) throws Exception {
		return guestMapper.updateGuest(guest);
	}
	@Override
	public int deleteGuest(int no) throws Exception {
		return guestMapper.deleteGuest(no);
	}
}