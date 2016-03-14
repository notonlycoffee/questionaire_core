<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<jsp:include page="/include.xhtml"></jsp:include>

</head>
<body class="easyui-layout">
	<div data-options="region:'west',width:'500',split:false" >
		<table id="roletable"></table>
	</div>
	<div data-options="region:'center',fit:true" style="overflow:scroll" >
		<ul id="privilege_tree">
		</ul>
	</div>
	
	<div id="toolbar" style="display:none;position:relative;" >
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doUser.addRole();return false;">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-user',plain:true" onclick="doUser.deleteRole();return false;">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-resetpsw',plain:true" onclick="accreditRole();return false;">授权</a>
	</div>
</body>
<script>
	
var base_path = '${pageContext.request.contextPath}';

$(function() {
	loadAllRole();
	var selector = $('#roletable').datagrid('getSelected');
	var result_id = null;
	selector==null?result_id='2222':result_id=selector.id;
	privilege_tree_fu(result_id);
})

	
function loadAllRole() {
	$('#roletable').datagrid({
		fit : true,
		method : 'post',
		url : base_path + '/usermanage/getAllRoleDialog.xhtml',
		iconCls : 'icon-ok',
		rownumbers : true,
		fitColumns : true,
		toolbar : '#toolbar',
		singleSelect : true,
		idField : 'id',
		nowrap : false,
		striped : true,
		remoteSort : false,
		loadMsg:'数据加载中,请稍等...',
		onLoadSuccess :function(data) {
			$.each(data.rows,function(i,e){
				if(e.name ==  '管理员') {
					$('#roletable').datagrid('selectRecord',e.id);
				}
			});
 		},
 		onCheck:function(rowIndex,rowData) {
 			privilege_tree_fu(rowData.id);
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
			title : '姓名',
			
		}, {
			field : 'descrip',
			width : 100,
			title : '描述'
		}] ]
	});
}

function privilege_tree_fu(id) {
	var url = base_path + '/usermanage/getRolePrivilege2assign.xhtml?'+'id='+id;
	$('#privilege_tree').tree({
		url:url,
		checkbox:true,
	});
}

function accreditRole() {
	var selector = $('#roletable').datagrid('getSelected');
	var selector_id = selector.id;
	var tree_se = $('#privilege_tree').tree('getChecked');
	var resource_ids = '';
	$.each(tree_se,function(i,e) {
		if(e.attributes != null) {
			resource_ids += e.id+','
		}
	})
	
	console.log(resource_ids);
	
	  $.ajax({
		url:base_path+'/rolemanager/assignRole.xhtml',
		data:{
			'role_id':selector_id,
			're_ids':resource_ids
			},
		type:'post',
		success:function(data) {
			
		}
	})  
	
}
	
</script>
</html>