package com.itwill.user.etc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserSQL;

public class UserDaoImplJdbcTemplate implements UserDao {
	private JdbcTemplate jdbcTemplate;

	public UserDaoImplJdbcTemplate() {
		System.out.println("#### UserDaoImplJdbcTemplate() : 디폴트생성자 호출  ");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("#### UserDaoImplJdbcTemplate : setJdbcTemplate(" + jdbcTemplate + ") 호출  ");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplate : create() 호출  ");
		return jdbcTemplate.update(UserSQL.USER_INSERT,
									user.getUserId(),
									user.getPassword(),
									user.getName(),
									user.getEmail());
	}

	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplate : update() 호출  ");
		return jdbcTemplate.update(UserSQL.USER_UPDATE,
				user.getPassword(),
				user.getName(),
				user.getEmail(),
				user.getUserId());
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplate : remove() 호출  ");
		return jdbcTemplate.update(UserSQL.USER_REMOVE,userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplate : findUser() 호출  ");
		return jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID,
				new Object[] { userId }, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplate : findUserList 호출  ");
		return jdbcTemplate.query(UserSQL.USER_SELECT_ALL, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplate : existedUser() 호출  ");
		int count=jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID_COUNT,new Object[] {userId},Integer.class);
		if(count==1) {
			return true;
		}else {
			return false;
		}
		
	}
}