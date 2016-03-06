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
	<div data-options="region:'north',href:'${pageContext.request.contextPath }/north.xhtml',border:false" style="height:65px;overflow:hidden;" ></div>
	
	
	<!-- west -->
	<div data-options="region:'west',href:'${pageContext.request.contextPath }/west.xhtml',border:'false',title:'导航菜单',split:'false'" style="width:180px;height:100%;"></div>
	
	<!-- center -->
	<div region="center" data-options="border:'false'">
		<div id="easyui_tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
			<div data-options="title:'首页',closable:false">
				<div style="text-align:center;margin:100px auto 0 auto;">欢迎使用系统</div>
			</div>
		</div>
	</div>
	
	
	
	<!-- footer -->
	<div data-options="region:'south',href:'${pageContext.request.contextPath }/south.xhtml',border:'false'" style="width:100%;height:30px;"></div>
	
</body>
<script>
	function addTab(node) {
		var currentTab = $('#easyui_tabs');
		if(currentTab.tabs('exists',node.text)) {
			currentTab.tabs('select',node.text);
		} else {
				var url = node.attributes.url;
				
				if(url && url.length>0) {
					url = '${pageContext.request.contextPath}' + url;
					var iframe = "<iframe src='" + (url) + "' frameborder='0' style='border:0;width:100%;height:100%;margin-top:1px;' scrolling=no ></iframe>";
					currentTab.tabs('add',{
						title:node.text,
						content:iframe,
						closable:true,
						fit : true,
						tools:[{
							iconCls:'icon-mini-refresh',
							handler : function(){
							 //刷新选项卡里的内容
							 var tab = currentTab.tabs('getTab',node.text);
							 currentTab.tabs('update',{
									tab:tab,
									options:tab.panel('options')
								});
							}
						}]
					});
				}
			}
			
	}
</script>
</html>