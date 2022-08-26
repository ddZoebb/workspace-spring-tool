package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository(value = "guestDaoImplMyBatis")
public class GuestDaoImplMyBatis implements GuestDao{
	@Autowired(required = false)
	private SqlSession sqlSession;
	
	public GuestDaoImplMyBatis() {
		System.out.println("#### GuestDaoImplMyBatis()기본생성자");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("#### GuestDaoImplMyBatis : setSqlSession("+sqlSession+") 메쏘드 호출");
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Guest> selectAll() throws Exception {
		return sqlSession.selectList("com.itwill.guest.mapper.GuestMapper.selectAll");
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return sqlSession.selectOne("com.itwill.guest.mapper.GuestMapper.selectByNo",no);
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		return sqlSession.insert(
				"com.itwill.guest.mapper.GuestMapper.insertGuest",guest);
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		return sqlSession.update(
				"com.itwill.guest.mapper.GuestMapper.updateGuest",guest);
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		return sqlSession.delete("com.itwill.guest.mapper.GuestMapper.deleteGuest",no);
	}

}
