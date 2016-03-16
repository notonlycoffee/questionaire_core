<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择题查看</title>
<jsp:include page="/include.xhtml"></jsp:include>
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:500px;">
	<div  style="text-align:center;" data-options="region:'north',border:'false',height:'80'">
		
		<div style="margin:20px auto 0 auto;width:1000px;">
 			<p>选择题查看</p>
 		</div>
		
	</div>
	<div data-options="region:'center',border:'false'">
		<table id="dg"></table>
	</div>
	
	</div>
	<div id="extToolbar" style="display:none;position:relative;" >
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deletequestion();return false;">删除题目</a>
	</div>
	
	
	<script>
	function deletequestion() {
		var row = $('#dg').datagrid('getSelected');
		console.log(row);
		if (!row) {
			parent.showWarningBox('请先选择一个题目');
			return;
		} else{
			$.messager.confirm('删除题目', '是否删除题目?', function(r){
				if (r){
					$.ajax({
						url:'${pageContext.request.contextPath}/choice/deleteChoice.xhtml',
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
				url : '${pageContext.request.contextPath}/choice/getAllChoice.xhtml',
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
					field : 'question',
					width : 100,
					title : '题目',
					
				}, {
					field : 'select',
					width : 100,
					title : '选项'
				}, {
					field : 'question_type',
					width : 100,
					title : '类型',
					formatter:function(value,row,index) {
						if(row.question_type == "0") {
							return row.question_type="单选";
						} else return row.question_type="多选";
					}
					
				}] ]
			})
		})
	</script>
	
	
</body>
</html>