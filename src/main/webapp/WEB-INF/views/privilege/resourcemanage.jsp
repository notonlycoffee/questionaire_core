<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资管理</title>
<jsp:include page="/include.xhtml"></jsp:include>

</head>
<body class="easyui-layout">
	
	<div data-options="region:'west',width:'200'" style="overflow:scroll">
		<ur id="privilege_tree"></ur>
	</div>
	
	<div data-options="region:'center'">
		<table id="resource_table"></table>
	</div>
	
	<div id="add_window"></div>
	<div id="update_window"></div>
	
	<div id="toolbar" style="display:none;position:relative;">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doResource.addResource()">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doResource.editResource()">修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="doResource.removeResource()" >删除</a>
	
	</div>
	
</body>
	<script>var CONTEXT_PATH='${pageContext.request.contextPath}'</script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/privilege/resourcemanage.js"></script>
</html>