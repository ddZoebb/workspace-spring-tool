package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import com.itwill.dto.Guest;

@Controller
public class SpringCustomTagSPELController {
	@RequestMapping("/jstl_fmt_i18n.do")
	public String jstl_fmt_i18n() {
		return "forward:/WEB-INF/views/jstl_fmt_i18n.jsp";
		// return "jstl_fmt_i18n";
	}

	@RequestMapping("/spring_customtag_spel.do")
	public String spring_customtag_spel(HttpServletRequest request) {

		request.setAttribute("price0", 3424);
		request.setAttribute("name0", "lee ju hee");
		request.setAttribute("price1", 4353);
		request.setAttribute("name1", "kang ju hee");
		request.setAttribute("married1", true);
		request.setAttribute("price2", 43533);
		request.setAttribute("name2", "Han ju hee");
		request.setAttribute("married2", false);

		request.setAttribute("guest", new Guest(1, "김숩미", "2022/08/31", "guard@naver.com", "http://www.google.com",
				"오늘은 수요일", "spring study"));
		return "spring_customtag_spel";
	}

	/************
	 * Spring JSP에서 국제화******************* 1. application-config.xml에
	 * MessageSource빈설정 <bean id="messageSource" class=
	 * "org.springframework.context.support.ResourceBundleMessageSource">
	 * <property name="basenames" value="messages/messages,messages/user"/> </bean>
	 *****************************************************/

	@RequestMapping("/spring_customtag_spel_i18n.do")
	public String spring_customtag_spel_i18n() {
		return "spring_customtag_spel_i18n";
	}
}
