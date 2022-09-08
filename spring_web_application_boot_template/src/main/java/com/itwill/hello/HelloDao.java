package com.itwill.hello;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	@Autowired
	private DataSource dataSource;

	public List<String> hello() throws Exception {
		List<String> helloList=new ArrayList<String>();
		helloList.add("KIM");
		helloList.add(dataSource.getConnection().toString());
		return helloList;
	}

}
