<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷查看</title>
<jsp:include page="/include.xhtml"></jsp:include>
</head>
<body>

	<div class="easyui-layout" style="width:100%;height:500px;">
	<div  style="text-align:center;" data-options="region:'north',border:'false',height:'80'">
		
		<div style="margin:20px auto 0 auto;width:1000px;">
 			<p>查看试卷计划</p>
 		</div>
		
	</div>
	<div data-options="region:'center',border:'false'">
		<table id="dg"></table>
	</div>
	
	</div>
	<div id="extToolbar" style="display:none;position:relative;" >
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="createplan();return false;">创建计划</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteplan();return false;">删除计划</a>
		
	</div>
	
	<div id="exam_plan_detail">
	
	</div>
	
	<div id="add_window"></div>

<script>

	function createplan() {
		$('#add_window').window({
			width:500,
			height:500,
			modal:true,
			title:'添加试卷计划',
			minimizable:false,
			maximizable:false,
			collapsible:false,
			href:'${pageContext.request.contextPath}/exam/createexamplanpage.xhtml',
		})
	}

	$(function() {
		loadallexamplan();
	})
	
	function loadallexamplan() {
		$('#dg').datagrid({

			fit : true,
			method : 'post',
			url : '${pageContext.request.contextPath}/exam/getAllExamPlan.xhtml',
			iconCls : 'icon-ok',
			rownumbers : true,
			fitColumns : true,
			toolbar : '#extToolbar',
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
				field : 'exam_identity',
				width : 100,
				title : '试卷编号',
				
			}, {
				field : 'name',
				width : 100,
				title : '试卷名称'
			}, {
				field : 'teacher_name',
				width : 100,
				title : '改卷老师'
			}, {
				field : 'closetime_str',
				width : 100,
				title : '试卷关闭时间',
			}, {
				field : 'publishtime_str',
				width : 100,
				title : '试卷推出时间',
			}] ]
		})	
	}
	
	
	
</script>
</body>
</html>