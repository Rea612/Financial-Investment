<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserMainPage</title>
</head>
<body background ="${pageContext.request.contextPath}/static/images/stock.jpg">
	<h3 style="color: #FFBEBE">
		Today is
		<%=new java.util.Date()%>.
	</h3>
	<br />
	<form action='${pageContext.request.contextPath}/login' method="post"
		id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h1>Welcome :
			${pageContext.request.userPrincipal.name}</h1>
	</c:if>
<%-- 	<p style = "color: green"><a href ="${pageContext.request.contextPath}/addstock"}>Click here to add more stocks to your account.</a></p> --%>
<%-- 	<p style = "color: purple"><a href ="${pageContext.request.contextPath}/viewStock"}>Click here to view your current stock.</a></p> --%>
	<h1><input type="button" value="Add Stock" onClick="javascript:window.location='addstock';"></h1>
	<h1><input type="button" value="View Stock" onClick="javascript:window.location='viewStock';"></h1>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<a href="javascript:formSubmit()"> Click here to logout</a>
</body>
</html>