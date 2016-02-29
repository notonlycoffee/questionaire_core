<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<jsp:include page="/include.xhtml"></jsp:include>

</head>
<body class="easyui-layout">

	<!-- header -->
	<div data-options="region:'north',border:'true'" style="width:100%;height:50px;background:yellow">a</div>
	
	
	
	<!-- west -->
	<div data-options="region:'west',border:'true'" style="width:100px;height:100%;background:blue;">c</div>
	
	<!-- center -->
	<div region="center" data-options="border:'true'">ddddddd<p>ddddd</p>
	<p>ddddd</p><p>ddddd</p><p>ddddd</p><p>ddddd</p><p>ddddd</p><p>ddddd</p>
	</div>
	
	
	<!-- footer -->
	<div data-options="region:'south',border:'true'" style="width:100%;height:50px;background:red;">b</div>
	
</body>
</html>