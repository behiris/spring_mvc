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
	location.href="/spring_mvc/hms/test2?num="+rowId;//이동
	//window.open('/spring_mvc/hms/test2?num='+rowId);//새창
}

function onCheckBtn2(){
	//선택한 row ID 값 가져올때 
	var rowId = $("#list2").jqGrid('getGridParam', 'selrow');
	//선택한 row 데이터 전부 가져올때
	//var userObject = $('#userListGrid').jqGrid("getRowData", rowId);
	//alert("선택한 행 : " + rowId);
	if(rowId == null)
		return false;
	location.href="/spring_mvc/hms/test2?num="+rowId;//이동
	//window.open('/spring_mvc/hms/test2?num='+rowId);//새창
}

function AddBtn(){
	location.href="/spring_mvc/hms/test3";
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
var mydata = [];
<c:forEach var="medicine" items="${medicines}" varStatus="status">
	var obj = {num:"${medicine.num}", name:"${medicine.name}", stock:"${medicine.stock}"};
	mydata.push(obj);
</c:forEach>
//{id:"1", name:"test", ssn:"123456-1234567", gender:"0", phone:"010-1234-1234", address:"부산시 해운대구 센텀시티 11층"},
//{id:"2", name:"test", ssn:"123456-1234567", gender:"1", phone:"010-1234-1234", address:"부산시 해운대구 센텀시티 11층"}
//{id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
for(var i=0;i<=mydata.length;i++){
	jQuery("#list").jqGrid('addRowData', i+1, mydata[i]);
}
//------------------------------------------------------------------------------------------------------------------
jQuery("#list2").jqGrid({
	datatype: "local",
	height:250,
   	colNames:['약번호', '이름', '발주개수'],
   	colModel:[
   		{name:'num', index:'num', width:60, sortable:false, resizable:false},
   		{name:'name', index:'name', width:100, sortable:false, resizable:false},
   		{name:'stock', index:'stock', width:90, align:"center", sortable:false, resizable:false}
   	],
   	multiselect: false,
   	caption: "발주 약 목록",
   	ondblClickRow : function(ids){
   		onCheckBtn2();
   	}
});
var mydata2 = [];
<c:forEach var="medicine" items="${add_medicines}" varStatus="status">
	var obj2 = {num:"${medicine.num}", name:"${medicine.name}", stock:"${medicine.stock}"};
	mydata2.push(obj2);
</c:forEach>
for(var i=0;i<=mydata2.length;i++){
	jQuery("#list2").jqGrid('addRowData', i+1, mydata2[i]);
}
</script> 
</body>
</html>