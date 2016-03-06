<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	
	<table id="roletable"></table>
	
</div>

<div id="toolbat" style="display:none;position:relative;" >
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doUser.addRole();return false;">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-user',plain:true" onclick="doUser.deleteRole();return false;">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-resetpsw',plain:true" onclick="doUser.accreditRole();return false;">授权</a>
	</div>
	
<script>
	$('#roletable').datagrid({
		url:'${pageContext.request.contextPath}'+'/usermanage/getAllRoleDialog.xhtml',
		fit : true,
		method : 'post',
		iconCls : 'icon-ok',
		rownumbers : true,
		fitColumns : true,
		toolbar : '#toolbat',
		singleSelect : true,
		nowrap : false,
		striped : true,
		remoteSort : false,
		pagination : true,
		loadMsg:'数据加载中,请稍等...',
		pageSize : 15,
		pageList : [ 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 ],
		onLoadSuccess:function(data) {
			console.log(data);
		},
		columns : [ [ {
			field : 'id',
			hidden : true,
			width : 100,
			title : '角色唯一id'
		},  {
			field : 'name',
			width : 100,
			title : '名称'
		},{
			field : 'descrip',
			width : 100,
			title : '说明',
			
		}] ]
	});
</script>