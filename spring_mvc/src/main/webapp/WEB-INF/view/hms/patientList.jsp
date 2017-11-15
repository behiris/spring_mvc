<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>환자 조회</title>
</head>
<body>
	<c:if test="${!empty patients}">
	<table border="1">
		<tr>
			
		</tr>
		<tr>
			<th>이름</th><th>수량</th>
		</tr>
		<c:forEach var="patient" items="${patients}">
		<tr>
			<td>${patient.num}</td>
			<td>${patient.name}</td>
			<td>${patient.gender}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>