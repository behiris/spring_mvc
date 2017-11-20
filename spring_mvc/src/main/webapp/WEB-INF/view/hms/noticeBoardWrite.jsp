<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성 중</title>
</head>
<body>

	<h2>게시글 작설</h2>
	<form:form action="writeNoticeBoard" commandName="cmd">

	<p>
		<label>제목 : <form:input path="subject"/>
		<form:errors path="subject"/>
		</label>
	</p>

	<p>
		<form:input path="content"/>
	</p>
	
	<input type="reset" value="다시작성">
	<input type="submit" value="올리기">
	</form:form>

</body>
</html>