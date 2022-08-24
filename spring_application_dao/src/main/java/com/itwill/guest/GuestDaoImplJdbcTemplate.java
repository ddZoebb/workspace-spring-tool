package com.itwill.guest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class GuestDaoImplJdbcTemplate implements GuestDao {
private JdbcTemplate jdbcTemplate;

public GuestDaoImplJdbcTemplate() {
System.out.println("### GuestDaoImplJdbcTemplate() 기본생성자 호출");
}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("### GuestDaoImplJdbcTemplate setJdbcTemplate() 호출");
	this.jdbcTemplate = jdbcTemplate;
}

	@Override
	public List<Guest> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GuestSQL.GUEST_SELECT_BY_NO, new Object[] {no},new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(GuestSQL.GUEST_INSERT,guest.getGuest_name(),guest.getGuest_email(),guest.getGuest_homepage(),guest.getGuest_title(),guest.getGuest_content());
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(GuestSQL.GUEST_UPDATE,guest.getGuest_name(),guest.getGuest_email(),guest.getGuest_homepage(),guest.getGuest_title(),guest.getGuest_content(),guest.getGuest_no());
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(GuestSQL.GUEST_DELETE,no);
	}

}
