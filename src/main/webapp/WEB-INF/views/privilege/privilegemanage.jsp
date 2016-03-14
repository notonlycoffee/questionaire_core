<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<jsp:include page="/include.xhtml"></jsp:include>

</head>
<body class="easyui-layout">

	<div data-options="region:'west',width:'300'">
		<a href="javascript:void(0);" class="easyui-linkbutton" onclick="addPrivilege()" style="margin:10px 0 0 20px;">添加</a><br /><br /><br />
		<ul id="privilege_tree"></ul>
	</div>	
	
	
	<div id="add_window"></div>
	
	<div data-options="region:'center',">
		<table id="pri_table_div"></table>
	</div>

</body>
<script>
	var base_path = '${pageContext.request.contextPath}' + '/privilegepage';
	$(function() {
		
		$('#privilege_tree').tree({
			url: base_path + '/getAllPrivilegePage.xhtml',
			onClick: function(node){
				$('#pri_table_div').datagrid({
					fit : true,
					method : 'post',
					queryParams: {
						id: node.id,
						},
					url : base_path + '/getPrivilegeResourceTable.xhtml',
					iconCls : 'icon-ok',
					rownumbers : true,
					fitColumns : true,
					singleSelect : true,
					idField : 'id',
					nowrap : false,
					striped : true,
					remoteSort : false,
					loadMsg:'数据加载中,请稍等...',
					onLoadSuccess :function(data) {
						},
						
					rowStyler : function(index, row) {
					},
					frozenColumns : [ [ {
						field : 'id',
						checkbox : true
					} ] ],
					columns : [ [  {
						field : 'text',
						width : 100,
						title : '资源名称',
						editor: {
							type:'textbox'
						},
						
					},{
						field : 'url',
						width : 100,
						title : '路径',
						
						
					}] ]
				})
			},
		})
	})
	
	function addPrivilege() {
		$('#add_window').window({
			width:300,
			height:350,
			href: base_path+'/addPrivilegePage.xhtml',
			minimizable:false,
			maximizable:false,
			collapsible:false,
			modal:true,
			iconCls:'icon-add',
			title:'添加资源',
			resizable:false,
		})
	}
	
	function addPrivilegeSure() {
		var pri_name = $('#pri_name').val();
		if(pri_name == "" || $.trim(pri_name) == "") {
			alert("您还没有输入");
			return ;
		} else {
			$.ajax({
				url:base_path + '/addPrivilegeSure.xhtml',
				type:'post',
				data:{'name':pri_name},
				success:function(data) {
					alert(data.message);
					$('#add_window').window('close');
				}
			})
		}
	}
	
	function daddPrivilegeCacel() {
		$('#add_window').window('close');
	}
	
</script>
</html>