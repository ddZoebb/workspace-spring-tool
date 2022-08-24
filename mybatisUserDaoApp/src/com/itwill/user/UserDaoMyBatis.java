package com.itwill.user;


import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class UserDaoMyBatis {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.itwill.user.mapper.UserMapper.";
	
	

	public UserDaoMyBatis() throws Exception {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	public User findUser(String userId) throws Exception {
		User findUser = null;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		findUser=sqlSession.selectOne(NAMESPACE+"findUser",userId);
		sqlSession.close();

		
		return findUser;
	}
	
	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	public int create(User user) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);

		int insertRowCount = sqlSession.insert(NAMESPACE+"insertUser", user);
		sqlSession.close();
		return insertRowCount;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	public int update(User user) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);

		int updateRowCount = sqlSession.update(NAMESPACE+"updateUser", user);
		sqlSession.close();

		return updateRowCount;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	public int remove(String userId) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);

		int removeRowCount = sqlSession.delete(NAMESPACE+"deleteUser", userId);
		sqlSession.close();

		return removeRowCount;
	}

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	public List<User> findUserList() throws Exception {
		List<User> findUserList =null;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		findUserList=sqlSession.selectList(NAMESPACE+"findUserList");
		sqlSession.close();
		return findUserList;
	}

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	public boolean existedUser(String userId) throws Exception {
		boolean isExist = false;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		User user=sqlSession.selectOne(NAMESPACE+"findUser", userId);
		if(user!=null) {
			isExist=true;
		}
		sqlSession.close();
		return isExist;
	}

}
