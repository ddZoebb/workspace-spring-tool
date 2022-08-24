package com.itwill.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill.guest.Guest;

public class SpringJdbcTemplateMain {

	public static void main(String[] args) {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill/dao/spring_jdbctemplate.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
		System.out.println("1.JdbcTemplate:"+jdbcTemplate);
		/*
		 * SELECT ==> queryForObject 반환타입[String,Wrapper,DTO]
		 */
		/*
		 * queryForObject 반환타입 : DTO 경우
		 */
		String selectDtoSql="select guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content from guest where guest_no=?";
		
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper = new BeanPropertyRowMapper<Guest>(Guest.class);
		
		Guest guest =jdbcTemplate.queryForObject(selectDtoSql,new Object[] {6},guestBeanPropertyRowMapper);
		System.out.println(guest);
		
		/*
		 * query [반환타입 List<Guest>]
		 * 
		 */
		String selectDtoListSql="select * from guest";
		List<Guest> guestList=jdbcTemplate.query(selectDtoListSql, guestBeanPropertyRowMapper);
		System.out.println(guestList);
		
		List<Map<String,Object>> mapList=jdbcTemplate.queryForList(selectDtoListSql);
		System.out.println(mapList);
		/*
		 * queryForObject 반환타입 : String 경우
		 */
		String selectStringsql="select guest_name from guest where guest_no=?";
		String guest_name=jdbcTemplate.queryForObject(selectStringsql, new Object[] {6}, String.class);
		System.out.println(guest_name);
		
		/*
		 * query[반환타입 List<String>]
		 */
		String selectStringListSql="select guest_name from guest";
		List<String> guestNameList=jdbcTemplate.queryForList(selectStringListSql,String.class);
		System.out.println(guestNameList);
		
		
		/*
		 * queryForObject 반환타입 : int 경우
		 */
		String selectIntsql="select guest_no from guest where guest_no=?";
		int guest_no=jdbcTemplate.queryForObject(selectIntsql, new Object[] {6}, Integer.class);
		System.out.println(guest_no);
		
		/*
		 * queryForList [반환타입 List<Integer>]
		 */
		String selectIntegerListSql="select guest_no from guest";
		List<Integer> guest_noList=jdbcTemplate.queryForList(selectIntegerListSql,Integer.class);
		System.out.println(guest_noList);
		
		/*******************
		 * update,delete,insert ==> update [rowCount(int)]
		 * 
		 */
		String insertSql="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		int rowCount=jdbcTemplate.update(insertSql,"문빈","handsome@naver.com","hot","수업끝","끝~~");
		System.out.println("insert : "+rowCount);
		String updateSql="update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		rowCount=jdbcTemplate.update(updateSql,"김민규","mmm@","homepage","쉬는시간이필요해","쉬시",6);
		System.out.println("update:"+rowCount);
		String deleteSql="delete from guest where guest_no=?";
		rowCount=jdbcTemplate.update(deleteSql,6);
		System.out.println(rowCount);
		
	}

}
