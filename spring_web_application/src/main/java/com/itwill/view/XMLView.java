package com.itwill.view;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class XMLView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(">>>>>>>>>>>>>XMLView.renderMergedOutputModel()");
		List<String> friendList = (List<String>) model.get("friendList");
		/************* XML 출력 *****************/
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<?xml version='1.0' encoding='UTF-8'?>");
		out.println("<friends>");
		for (String friend : friendList) {
			out.println(friend);
		}
		out.println("</friends>");
	}
	/**********************
	 * HTML출력[HTML]*****************
	 * response.setContentType("text/html;charset=UTF-8"); PrintWriter out =
	 * response.getWriter(); out.println("
	 * <h3>나의친구들</h3>
	 * <hr>
	 * "); out.println("
	 * <ol>
	 * "); for(String friend:friendList) { out.println("
	 * <li>"+friend+"</li>"); } out.println("
	 * </ol>
	 * ");
	 *********************************************/

	/*********************
	 * forward************************** RequestDispatcher rd =
	 * request.getRequestDispatcher("xxx.jsp"); rd.forward(request, response);
	 ********************************************************/
	/*********************
	 * redirect************************** response.sendRedirect("xxx.do");
	 ********************************************************/

}
