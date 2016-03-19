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
 			<p>查看试卷</p>
 		</div>
		
	</div>
	<div data-options="region:'center',border:'false'">
		<table id="dg"></table>
	</div>
	
	</div>
	<div id="extToolbar" style="display:none;position:relative;" >
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="createeexam();return false;">创建试卷</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteexam();return false;">删除试卷</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="checkeexamdetail();return false;">查看详细试卷</a>
	</div>
	
	<div id="exam_detail">
	
	</div>
	
	
	<script>
	
	function createeexam() {
		
			$('#exam_detail').window({
				width:1000,
				height:500,
				modal:true,
				title:'试卷详细内容',
				minimizable:false,
				maximizable:false,
				collapsible:false,
				href:'${pageContext.request.contextPath}/exam/checkDetailExam.xhtml',
			})
		
	}
	
	function deleteexam() {
		var row = $('#dg').datagrid('getSelected');
		if (!row) {
			parent.showWarningBox('请先选择一个试卷条目');
			return;
		} else{
			$.messager.confirm('删除试卷', '是否删除试卷?', function(r){
				if (r){
					$.ajax({
						url:'${pageContext.request.contextPath}/exam/deleteexam.xhtml',
						type:'post',
						data:{id:row.id},
						success:function(data) {
							alert(data.message);
							$('#dg').datagrid('reload');
						}
					})
				}
			});
			
		}
	}
		$(function() {
			$('#dg').datagrid({
				fit : true,
				method : 'post',
				url : '${pageContext.request.contextPath}/exam/getAllExam.xhtml',
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
					field : 'author',
					width : 100,
					title : '试卷编辑'
				}, {
					field : 'type',
					width : 100,
					title : '试卷类型',
				}] ]
			})
		})
		
		
		function checkeexamdetail() {
			var row = $('#dg').datagrid('getSelected');
			if (!row) {
				parent.showWarningBox('请先选择一个试卷条目');
				return;
			} else{
				$('#exam_detail').window({
					width:800,
					height:500,
					modal:true,
					title:'查看试卷详细内容',
					minimizable:false,
					maximizable:false,
					collapsible:false,
					href:'${pageContext.request.contextPath}/exam/getDetailExamPage.xhtml?id='+row.id,
				})
			}
		}
		
	</script>
	
	
</body>
</html>