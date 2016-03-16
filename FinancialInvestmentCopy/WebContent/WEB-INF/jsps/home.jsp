<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background ="${pageContext.request.contextPath}/static/images/background.jpg">
	<h1> Welcome to the most powerful financial investment tool!</h1>
	
<%-- 	<p><a href ="${pageContext.request.contextPath}/createuser"}></a></p> --%>
<h1><input type="button" value="User Login" onClick="javascript:window.location='login';"></h1>
<h1><input type="button" value="Create a New User" onClick="javascript:window.location='createuser';"></h1>

<%-- 	<p><a href ="${pageContext.request.contextPath}/login"}>User Login</a></p> --%>

	
	
	
	

</body>
</html>