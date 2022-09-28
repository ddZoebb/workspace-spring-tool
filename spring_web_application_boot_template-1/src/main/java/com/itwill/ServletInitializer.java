package com.itwill;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	/*
 web.xml 관련된 설정을 여기에 ~ (인코딩 설정 등... 
	안 해도 되지만 디폴트 설정 변경하고 싶은 경우에 작성) */

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringWebApplicationBootTemplate1Application.class);
	}

}
