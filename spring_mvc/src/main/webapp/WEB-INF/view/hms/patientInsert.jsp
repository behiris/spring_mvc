<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>환자 등록</title>
</head>
<body>

	<h2>환자등록</h2>
	<form:form action="insertPatient" commandName="cmd">

	<p>
		<label>이름 <br>
		<form:input path="name"/>
		<form:errors path="name"/>
		</label>
	</p>
	<p>
		<label>성별 <br>
		<input type="radio" name="male" value="1">남
		<input type="radio" name="female" value="2">여
		<form:errors path="gender"/>
		</label>
	</p>
	<p>
		<label>주민번호 <br>
		<form:input path="ssn"/>
		<form:errors path="ssn"/>
		</label>
	</p>
	<p>
		<label>연락처 <br>
		<form:input path="phone"/>
		<form:errors path="phone"/>
		</label>
	</p>
	<p>
		<label> 주소지 <br>
		<form:input path="zipcode"/>
		</label>
	</p>
	<p>
		<form:input path="address1"/> <form:input path="address2"/>
	</p>
	
	<input type="reset" value="다시작성">
	<input type="submit" value="등록">
	</form:form>
	
</body>
</html>