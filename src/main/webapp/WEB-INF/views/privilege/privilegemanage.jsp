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
		<table id="privilege_tree"></table>
	</div>	
	
	
	<div id="add_window"></div>
	
	<div data-options="region:'center',">
		<table id="pri_table_div"></table>
	</div>
	
	<div id="extToolbar" style="display:none;position:relative;">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addPrivilege()">添加权限</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="deletePrivilege()">删除权限</a>
	</div>

</body>
<script>
	var base_path = '${pageContext.request.contextPath}' + '/privilegepage';
	//url: base_path + '/getAllPrivilegePage.xhtml',  请求获得权限
	$(function() {
		$('#privilege_tree').datagrid({
			fit : true,
			method : 'post',
			url: base_path + '/getAllPrivilegePage.xhtml',
			iconCls : 'icon-ok',
			rownumbers : true,
			fitColumns : true,
			toolbar : '#extToolbar',
			singleSelect : true,
			idField : 'id',
			nowrap : false,
			striped : true,
			onClickRow:function(rowIndex, rowData) {
				loadPrivilegeResource(rowData.id);
			},
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
				field : 'name',
				width : 100,
				title : '名称',
				
			}] ]
		})

	})
	
	
	function loadPrivilegeResource(id_) {
		$('#pri_table_div').datagrid({
			fit : true,
			method : 'post',
			queryParams: {
				id: id_,
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
	}
	
	
	
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
	
	
	function deletePrivilege() {
		//删除权限之前要删除资源,删除资源要删除角色中分配的资源
		//删除权限  ---->  删除资源    ----->删除角色下的资源
		alert("写了一部分,还不完善   privilegemanage.jsp");
		return;
		var row = $('#privilege_tree').datagrid('getSelected');
		if (!row) {
			parent.showWarningBox('请先选择一个权限');
			return;
		} else {
			$.messager.confirm('删除权限', '是否删除权限?', function(r){
				if (r){
					$.ajax({
						url: base_path + '/deletePrivilege.xhtml',
						type:"post",
						data:{'id':row.id},
						success:function(data) {
							parent.showWarningBox(data.message);
							$('#privilege_tree').datagrid('reload');
						}
					});
					
				}
			});
		}
		
	}
	
	
	
	
	
	
	
	
	

			
</script>
</html>