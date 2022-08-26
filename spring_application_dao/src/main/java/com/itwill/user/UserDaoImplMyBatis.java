package com.itwill.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class UserDaoImplMyBatis implements UserDao {

	private SqlSession sqlSession;
	
	public final static String NAMESPACE=
			"com.itwill.user.mapper.UserMapper.";
	
	public UserDaoImplMyBatis() {
		System.out.println("#### UserDaoImplMyBatis() : 디폴트생성자 호출  ");
	}
	public UserDaoImplMyBatis(SqlSession sqlSession) {
		System.out.println("#### UserDaoImplMyBatis(SqlSession sqlSession) : 생성자 호출  ");
		this.sqlSession = sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("#### UserDaoImplMyBatis.setSqlSession("+sqlSession+") : 호출  ");
		this.sqlSession = sqlSession;
	}
	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : create() 호출  ");
		int insertRowCount=sqlSession.insert(NAMESPACE+"create", user);
		return insertRowCount;
	}

	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : update() 호출  ");
		int updateRoweCount=sqlSession.insert(NAMESPACE+"update", user);
		return updateRoweCount;
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : remove() 호출  ");
		int removeRoweCount=sqlSession.insert(NAMESPACE+"remove", userId);
		return removeRoweCount;
	}
	
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUser() 호출  ");
		User user=sqlSession.selectOne(NAMESPACE+"findUser", userId);
		return user;
	}
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUserList 호출  ");
		List<User> userList=sqlSession.selectList(NAMESPACE+"findUserList");
		return userList;
	}
	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplMyBatis : existedUser 호출  ");
		int  count = sqlSession.selectOne(NAMESPACE+"existedUser", userId);
		boolean isExist=false;
		if(count==1) {
			isExist=true;
		}else {
			isExist=false;
		}
		return isExist;
	}
	
}