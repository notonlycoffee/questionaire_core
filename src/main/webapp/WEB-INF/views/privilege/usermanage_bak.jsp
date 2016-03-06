<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<jsp:include page="/include.xhtml"></jsp:include>

</head>
<body class="easyui-layout">
	<div  style="text-align:center;" data-options="region:'north',border:'false',height:'80'">
		
		<div style="margin:20px auto 0 auto;width:1000px;">
 		<span style="font-size:18px;color:#A9A9A9;">姓名:</span><input id="username" type="text" style="font-size:18px;height:20px;color:#A9A9A9;" /> &nbsp;&nbsp;&nbsp;&nbsp;
		<span style="font-size:18px;color:#A9A9A9;">工号(或学号):</span><input type="text" id="num" style="font-size:18px;height:20px; color:#A9A9A9;" />&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:void(0);" class="easyui-linkbutton" style="background:#EF9A9A;margin-top:-5px;width:60px;" onclick="doUser.searchUser();return false;">查&nbsp;询</a>
		</div>
		
	</div>
	<div data-options="region:'center',border:'false'">
		<table id="dg"></table>
	</div>
	
	<div id="extToolbar" style="display:none;position:relative;" >
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doUser.toAdd();return false;">新增用户</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-user',plain:true" onclick="doUser.toRole();return false;">分配角色</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-resetpsw',plain:true" onclick="doUser.resetPwd();return false;">重置密码</a>
	</div>
	
	
</body>
<script>
	var CONTEXT_PATH = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/privilege/usermanage.js"></script>
</html>