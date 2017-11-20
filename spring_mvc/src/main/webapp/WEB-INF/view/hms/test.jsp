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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/test.js"></script>
<script>
function onCheckBtn(){
	//선택한 row ID 값 가져올때 
	var rowId = $("#list").jqGrid('getGridParam', 'selrow');
	//선택한 row 데이터 전부 가져올때
	//var userObject = $('#userListGrid').jqGrid("getRowData", rowId);
	//alert("선택한 행 : " + rowId);
	if(rowId == null)
		return false;
	//location.href="/spring_mvc/hms/test2?num="+rowId;//이동
	window.open('/spring_mvc/hms/test2?num='+rowId);//새창
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>테스트</title>
</head>
<body>
<table>
<tr>
	<td><table id="list"></table></td><td valign="middle"><input type="button" value="→" onclick="onCheckBtn()"></td><td><table id="list2"></table></td>
</tr>
<tr>
<td colspan="3" align="right"><input type="button" value="발주" onclick="AddBtn()"></td>
</tr>
</table>

<script>
jQuery("#list").jqGrid({
	datatype: "local",
	height:250,
   	colNames:['약번호', '이름', '보유재고'],
   	colModel:[
   		{name:'num', index:'num', width:60, sortable:false, resizable:false},
   		{name:'name', index:'name', width:100, sortable:false, resizable:false},
   		{name:'stock', index:'stock', width:90, align:"center", sortable:false, resizable:false}//,
   		//{name:'regdate',index:'regdate', width:90, sorttype:"date", resizable:false}
   	],
   	multiselect: false,
   	caption: "보유 약 목록",
   	ondblClickRow : function(ids){
   		//alert(ids);//ids : 인덱스
   		onCheckBtn();
   	}
   	
});
<c:forEach var="medicine" items="${medicines}" varStatus="status">
	var obj = {num:"${medicine.num}", name:"${medicine.name}", stock:"${medicine.stock}"};
	jQuery("#list").jqGrid('addRowData', '${medicine.num}', obj);
</c:forEach>
</script> 
</body>
</html>