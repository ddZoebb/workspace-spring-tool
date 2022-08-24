package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestDaoImplMyBatis implements GuestDao {
	private SqlSession sqlSession;
	public static final String NAMESPACE="com.itwill.guest.mapper.GuestMapper.";
	

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Guest> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.itwill.guest.mapper.GuestMapper.selectGuest");
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"selectGuestByNo",no);
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"insertGuest",guest);
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"updateGuest",guest);
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"deleteGuest",no);
	}

}
