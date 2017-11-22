<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/ui.jqgrid.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/grid.locale-kr.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.jqGrid.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>���� ����</title>
</head>
<body>

	<table id="list">
	</table>
	<script>
		jQuery("#list").jqGrid({
			datatype : "local",
			height : 250,
			colNames : [ '���ȣ', '���', '���� ��', '���� ��¥' ],
			colModel : [ {
				name : 'num',
				index : 'num',
				width : 60,
				align : "center",
				sortable : false,
				resizable : false
			}, {
				name : 'name',
				index : 'name',
				width : 100,
				align : "center",
				sortable : false,
				resizable : false
			}, {
				name : 'stock',
				index : 'stock',
				width : 90,
				align : "center",
				sortable : false,
				resizable : false
			}, {
				name : 'date',
				index : 'date',
				width : 90,
				align : "center",
				sorttype : "false",
				resizable : false
			} ],
			multiselect : false,
			caption : "���� ����",
			align : "center",
			hidegrid:false,
			ondblClickRow : function(ids) {
				//alert(ids);//ids : �ε���
				onCheckBtn();
			}
		});
		<c:forEach var="medicineStock" items="${medicineStocks}" varStatus="status">
		var obj = {
			num : "${medicineStock.num}",
			name : "${medicineStock.name}",
			stock : "${medicineStock.stock}",
			date : "${medicineStock.regdate}"
		};
		jQuery("#list").jqGrid('addRowData', '${medicineStock.num}', obj);
		</c:forEach>
	</script>
</body>
</html>