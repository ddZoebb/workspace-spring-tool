<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${pageContext.request.locale.language}"/>
<fmt:setBundle basename="messages/messages"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL I18N[Internationalization]국제화</h1><hr/>
<ol>
	<li><fmt:message key="user.existed.exception">
	<fmt:param value="${id}"/>
	</fmt:message></li>
	<li><fmt:message key="user.notfound.exception">
	<fmt:param value="${'tomato'}"></fmt:param>
	</fmt:message></li>
	<li><fmt:message key="password.mismatch.exception">
	<fmt:param value="${'김경호'}">
	
	</fmt:param>
	</fmt:message></li>
</ol>

</body>
</html>