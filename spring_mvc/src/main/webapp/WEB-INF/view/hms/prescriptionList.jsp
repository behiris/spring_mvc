<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>처방 조회</title>
<script>
function a(num){
	alert(num);
	location.href="/spring_mvc/hms/prescriptionUpdate?num="+num;
}
</script>
</head>
<body>
	<form:form>
		<c:if test="${!empty prescriptions}">
			<table border="1">
				<tr>
					<th>진료과</th>
					<th>진단명</th>
					<th>처방 의약품</th>
					<th>처방용법</th>
					<th>환자명</th>
					<th>담당의</th>
					<th>진료일</th>
					<th>체크</th>
					<th>비고</th>
				</tr>
				<c:forEach var="prescription" items="${prescriptions}">
					<tr>
						<td>${prescription.department}</td>
						<td>${prescription.disease}</td>
						<td>${prescription.medicine}</td>
						<td>${prescription.desc}</td>
						<td>${prescription.patient}</td>
						<td>${prescription.doctor}</td>
						<td>${prescription.regdate}</td>
						<td> <input type="button" value="처방하기"
							onclick="a(${prescription.num})" /></td>
						<td>${prescription.check}
						 <c:if test="${prescription.check == 1}">
								11111111111
							</c:if>
						<c:if test="${prescription.check == 0}">
								000000000000
							</c:if></td>

					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>