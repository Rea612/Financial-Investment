<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Stock</title>
</head>
<body  bgcolor="#FFFACD">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2 style="color: #F4C2C2">Hi,
			${pageContext.request.userPrincipal.name}</h2>
	</c:if>

	<h2 style="color:#F4C2C2">You can add any stock you want in this
		page!</h2>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/addStock" commandName="stock">
<%-- 		<form action = "${pageContext.request.contextPath}/viewStock" METHOD = "POST"> --%>
		<table class="stocklist">
			<tr>
				<td>Stock ID: &nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>Stock Name &nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp; Stock Price</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp; Quantity</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp; Total</td>
			</tr>

			<tr>
				<td class="label">1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="label"><c:out value="${name1}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${price1}"></c:out></td>
				<td class="label"><input class="control" value="                " type="text" name = "quantity1" /></td>
				
				<td class="label"><input class="control" value="Add to Account"
					type="submit" /></td>
			</tr>
			<tr>
				<td class="label">2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="label"><c:out value="${name2}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${price2}"></c:out></td>
				<td class="label"><input class="control" value="" type="text" /></td>
				<td class="add"><input class="control" value="Add to account"
					type="submit" /></td>

			</tr>
			<tr>
				<td class="label">3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="label"><c:out value="${name3}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${price3}"></c:out></td>
				<td class="label"><input class="control" value="" type="text" /></td>
				<td class="add"><input class="control" value="Add to account"
					type="submit" /></td>

			</tr>
			<tr>
				<td class="label">4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="label"><c:out value="${name4}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${price4}"></c:out></td>
				<td class="label"><input class="control" value="" type="text" /></td>
				<td class="add"><input class="control" value="Add to account"
					type="submit" /></td>

			</tr>
			<tr>
				<td class="label">5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="label"><c:out value="${name5}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${price5}"></c:out></td>
				<td class="label"><input class="control" value="" type="text" /></td>
				<td class="add"><input class="control" value="Add to account"
					type="submit" /></td>

			</tr>
			<tr>
				<td class="label">6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="label"><c:out value="${name6}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${price6}"></c:out></td>
				<td class="label"><input class="control" value="" type="text" /></td>
				<td class="add"><input class="control" value="Add to account"
					type="submit" /></td>

			</tr>
		</table>
	</sf:form>
	<input type="button" value="Exit" onClick="javascript:window.location='usermainpage';">


</body>
</html>