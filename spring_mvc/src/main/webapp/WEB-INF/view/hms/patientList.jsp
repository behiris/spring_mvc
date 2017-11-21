<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/jquery-ui.min.css"/>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/ui.jqgrid.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/grid.locale-kr.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jqGrid.min.js"></script>
<script>
function onCheckBtn(){
	//선택한 row ID 값 가져올때 
	var rowId = $("#list").jqGrid('getGridParam', 'selrow');
	//선택한 row 데이터 전부 가져올때
	//var userObject = $('#userListGrid').jqGrid("getRowData", rowId);
	//alert("선택한 행 : " + rowId);
	if(rowId == null)
		return false;
	//location.href="/spring_mvc/hms/patientUpdate?num="+rowId;//이동
	window.open('/spring_mvc/hms/patientInfo?num='+rowId);//새창
}
</script>

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
		<table id="list">
		</table>
		<table>
		<tr>
		<td><a href="<c:url value='/hms/patientInsert'/>" target="_blank"><input type="button" value="추가"></a></td>
		</tr>
		</table>
		<script>
		jQuery("#list").jqGrid({
			datatype: "local",
			height:250,
   			colNames:['회원번호', '이름', '성별','주소지'],
   			colModel:[
   			{name:'num', index:'num', width:60, sortable:false, resizable:false},
   			{name:'name', index:'name', width:100, sortable:false, resizable:false},
   			{name:'gender', index:'gender', width:90, align:"center", sortable:false, resizable:false},
   			{name:'address1',index:'address1', width:90, sorttype:"false", resizable:false}
   		],
   		multiselect: false,
   		caption: "등록 환자 목록",
   		ondblClickRow : function(ids){
   			//alert(ids);//ids : 인덱스
   			onCheckBtn();
   		} 	
	});
		<c:forEach var="patient" items="${patients}" varStatus="status">
			var obj = {num:"${patient.num}", name:"${patient.name}", gender:"${patient.gender}", address1:"${patient.address1} ${patient.address2}"};
			jQuery("#list").jqGrid('addRowData', '${patient.num}', obj);
		</c:forEach>
	</script> 
	</body>
</html>