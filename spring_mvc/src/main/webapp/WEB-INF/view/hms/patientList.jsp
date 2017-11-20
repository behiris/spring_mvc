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
		<form:form commandName="cmd" action="patientSearch">//환자 검색기능
		<p>
			<label>환자 조회 : 
			<form:input path="name"/>
			</label>
			<input type="submit" value="조회">
		</p>
		</form:form>
			
		<table border="1">
		<tr>
			<th>이름</th><th>성별</th>
		</tr>
		<c:forEach var="patient" items="${patients}">
		<tr>
			<td>${patient.num}</td>
			<td>${patient.name}</td>
			<td>${patient.gender}</td>
		</tr>
		</c:forEach>
		<tr>
		<td><input type="button" value="추가"><a href="<c:url value='/hms/addPatient'/>" target="_blank"></a></td>
		<td><input type="button" value="수정"><a href="<c:url value='/hms/updatePatient'/>" target="_blank"></a></td>
		</tr>
	</table>
</body>
</html>