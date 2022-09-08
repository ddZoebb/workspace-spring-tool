<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>HELLO</h3>
<ol>
<c:forEach items="${helloList}" var="hello">
<li>${hello}</li>
</c:forEach>
</ol>
</body>
</html>