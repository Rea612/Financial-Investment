<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Login Page</title>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<body onload='document.loginForm.j_username.focus();' background ="${pageContext.request.contextPath}/static/images/welcome.jpg">



	<h1>Please login with your username and password</h1>
	<c:if test="${param.error != null}">

		<p class="error">Login failed. Check that your username and
			password are correct.</p>

	</c:if>
	<form name='loginForm'
		action='${pageContext.request.contextPath}/login' method='POST'>
		<table class=formtable>
			<tr>
				<td class = "label">Username:</td>
				<td><input class = "control" type='text' name='username'></td>
			</tr>
			<tr>
				<td class ="label" >Password:</td>
				<td><input class = "control" type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	</form>
	<p class = "text">Not a user? Please click create a new user</p><h3><input type="button" value="Create a New User" onClick="javascript:window.location='createuser';"></h3>


</body>
</html>