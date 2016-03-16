<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background ="${pageContext.request.contextPath}/static/images/green.jpg">

	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate" commandName="user">
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td><sf:input class="control" path="name" name="name"
						type="text" /><br/><sf:errors path = "name" cssClass="errors"></sf:errors></td>
				
			</tr>
			<tr>
				<td class="label">Address:</td>
				<td><sf:input class="control" path="address" name="address"
						type="text" /><br/><sf:errors path = "address" cssClass="errors"></sf:errors></td>
				
			</tr>
			<tr>
				<td class="label">City:</td>
				<td><sf:input class="control" path="city" name="city"
						type="text" /><br/><sf:errors path = "city" cssClass="errors"></sf:errors></td>
				
			</tr>
				<tr>
				<td class="label">Zip:</td>
				<td><sf:input class="control" path="zip" name="zip"
						type="text" /><br/><sf:errors path = "zip" cssClass="errors"></sf:errors></td>
				
			</tr>
			<tr>
				<td class="label">User Name:</td>
				<td><sf:input class="control" path="username" name="username"
						type="text" /><br/><sf:errors path = "name" cssClass="errors"></sf:errors></td>
				
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input class="control" path="password" name="password"
						type= "password" /><br/><sf:errors path = "password" cssClass="errors"></sf:errors></td>
				
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" path="email" name="email"
						type="text" /><br/><sf:errors path = "email" cssClass="errors"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Member before?(T/F):</td>
				<td><sf:input class="control" path="enabled" name="enabled"
						type="text" /><br/><sf:errors path = "enabled" cssClass="errors"></sf:errors></td>
			</tr>
			<tr>
				<td class="label"><input class="control" value="Create Account"
					type="submit" /></td>
			</tr>

		</table>
	</sf:form>



</body>
</html>