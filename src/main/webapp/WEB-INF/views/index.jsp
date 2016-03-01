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
	<%-- <div data-options="region:'north',href:'${ctx }/north.xhtml',border:'false'" style="width:100%;height:50px;"></div> --%>
	<%-- <div data-options="region:'north',href:'${ctx }/north.xhtml',border:false" style="height:80px;border-bottom:solid 1px red;overflow:hidden;"></div> --%>
	<div data-options="region:'north',href:'${ctx }/north.xhtml',border:false" style="height:65px;overflow:hidden;" ></div>
	
	
	<!-- west -->
	<div data-options="region:'west',href:'${ctx }/west.xhtml',border:'false',title:'导航菜单',split:'false'" style="width:180px;height:100%;"></div>
	
	<!-- center -->
	<div region="center" data-options="border:'false'">
	<div id="tt" class="easyui-tabs" style="width:500px;height:250px;">   
    <div title="Tab1" style="padding:20px;display:none;">   
        tab1    
    </div>   
    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">   
        tab2    
    </div>   
    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">   
        tab3    
    </div>   
</div>
	</div>
	
	
	
	<!-- footer -->
	<div data-options="region:'south',href:'${ctx }/south.xhtml',border:'false'" style="width:100%;height:30px;"></div>
	
</body>
</html>