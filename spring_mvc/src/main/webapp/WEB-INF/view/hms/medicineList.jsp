<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 조회</title>
</head>
<body>
	<c:if test="${!empty medicines}">
	<table border="1">
		<tr>
			<th>이름</th><th>수량</th>
		</tr>
		<c:forEach var="medicine" items="${medicines}">
		<tr>
			<td>${medicine.name}</td>
			<td>${medicine.stock}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>