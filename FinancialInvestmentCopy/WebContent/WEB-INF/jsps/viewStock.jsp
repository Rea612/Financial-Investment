<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Current Stocks</title>
</head>
<body background ="${pageContext.request.contextPath}/static/images/up.jpg">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h1>Welcome :
			${pageContext.request.userPrincipal.name}</h1>
	</c:if>
	
	<table class = "weather" align="right">
	<tr>
	<td><p >The local weather in <c:out value="${location}"></c:out> is:</p></td>
	</tr>
	<tr>
	<td>Temperature: <c:out value="${temp}"></c:out></td>
	</tr>
	<tr>
	<td>Humidity: <c:out value="${humidity}"></c:out></td>
	</tr>
	<tr>
	<td>Wind: <c:out value="${wind}"></c:out></td>
	</tr>
	<tr>
	<td>Weather: <c:out value="${weather}"></c:out></td>
	</tr>
	</table>
	<p class="stockview">Currently, you have following stocks in your account.</p>
	<table>
	<tr>
	<td class="stock"><c:out value="${stock}"></c:out></td>
	</tr>
	</table>
	
	<a href="${pageContext.request.contextPath}/usermainpage">Click here to return to your main page.
	</a>


</body>
</html>