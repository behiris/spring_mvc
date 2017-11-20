<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>환자 정보 수정</title>
</head>
<body>

	<h2>환자등록</h2>
	<form:form action="patientUpdate" commandName="cmd">
	<form:hidden path="num" value="${patient.num}"/>
	<p>
		<label>이름 <br>
		<form:input path="name" value="${patient.name}"/>
		<form:errors path="name"/>
		</label>
	</p>
	<p>
		<label>성별 <br>
		<c:if test = "${patient.gender == 1}" var="male">
		<form:radiobutton path="gender" value="1" checked = "true"/>남
		<form:radiobutton path="gender" value="2" />여
		</c:if>
		
		<c:if test = "${patient.gender != 1}" var="female">
		<form:radiobutton path="gender" value="1" />남
		<form:radiobutton path="gender" value="2" checked = "true"/>여
		</c:if>
		
		<form:errors path="gender"/>
		</label>
	</p>
	<p>
		<label>주민번호 <br>
		<form:input path="ssn" value="${patient.ssn}"/>
		<form:errors path="ssn"/>
		</label>
	</p>
	<p>
		<label>연락처 <br>
		<form:input path="phone" value="${patient.phone}"/>
		<form:errors path="phone"/>
		</label>
	</p>
	<p>
		<label> 주소지 <br>
		<form:input path="zipcode" value="${patient.zipcode}"/>
		</label>
	</p>
	<p>
		<form:input path="address1" value="${patient.address1}"/>
		<form:input path="address2" value="${patient.address2}"/>
	</p>
	
	<input type="reset" value="다시작성">
	<input type="submit" value="수정등록">
	</form:form>
	
</body>
</html>