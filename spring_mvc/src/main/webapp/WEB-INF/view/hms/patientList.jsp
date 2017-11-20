<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>환자 조회</title>
</head>
<body>
		<form:form commandName="cmd" action="patientSearch">
		<p>
			<label>환자 조회 : 
			<form:input path="name"/>
			</label>
			<input type="submit" value="조회">
		</p>
		</form:form>
			
		<table border="1">
		<tr>
			<th>회원 번호</th><th>이름</th><th>성별</th><th>주소지</th>
		</tr>
		<c:forEach var="patient" items="${patients}">
		<tr>
			<td>${patient.num}</td>
			<td>${patient.name}</td>
			<td>${patient.gender}</td>
			<td>${patient.address1} ${patient.address2}</td>
		</tr>
		</c:forEach>
		<tr>
		<td><a href="<c:url value='/hms/patientInsert'/>" target="_blank"><input type="button" value="추가"></a></td>
		</tr>
	</table>
</body>
</html>