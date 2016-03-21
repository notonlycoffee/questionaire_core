<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生答案管理</title>
<jsp:include page="/include.xhtml"></jsp:include>
</head>
<body>
	
	<div style="height:300px;">
		<table id="answer_table"></table>
	</div>
	
	<div id="detail_window" style="display:none;">
		<div style="overflow:scroll;height:500px;">
			<p style="font-size:20px;font-weight:bolder;">选择题</p>
			<div style="height:300px">
				<table id="detail_tables"></table>
			</div>
			<br /><br />
			<p style="font-size:20px;font-weight:bolder;">解答题</p>
			<div style="height:300px;">
				<table id="detail_tables_question"></table>
			</div>
			<br /><br />
		</div>
	</div>
	
	
</body>

<script>
	var id='${exam_id}';
	$(function() {
		loadStudentAnswer(id);
	})
	
	function loadStudentAnswer(id) {
		$('#answer_table').datagrid({
			fit : true,
			method : 'post',
			url : '${pageContext.request.contextPath}/answer/getAnswerStudents.xhtml',
			queryParams:{id:id},
			iconCls : 'icon-ok',
			rownumbers : true,
			fitColumns : true,
			//toolbar : '#extToolbar',
			singleSelect : true,
			idField : 'userId',
			nowrap : false,
			striped : true,
			remoteSort : false,
			pagination : true,
			loadMsg:'数据加载中,请稍等...',
			onLoadSuccess:function(data) {
			},
			rowStyler : function(index, row) {
			},
			pageSize : 15,
			pageList : [ 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 ],
			frozenColumns : [ [ {
				field : 'exam_id',
				checkbox : true
			} ] ],
			columns : [ [  {
				field : 'name',
				width : 100,
				title : '学生姓名'
			},{
				field : 'exam_identity',
				width : 100,
				title : '试卷编号',
			
			},{
				field:'student_id',
				width:100,
				title:'学生id',
				hidden:true,
			}, {
				field : 'exam_name',
				width : 100,
				title : '试卷名称'
			},{
				field:'dddd',
				width:100,
				title:'查看详细答案',
				formatter:function(value,row,index) {
					var exam_id = row.exam_id;
					var student_id = row.student_id;
					return "<a style='color:#3385FF' href='javascript:void(0)' onclick=\"checkDetailAnswer('"+exam_id+"','"+student_id+"')\">查看详细</a>";
				}
			}] ]
		})
	}
	
	function checkDetailAnswer(exam_id,student_id) {
		$('#detail_window').show();
		$('#detail_window').window({
			width:800,
			height:500,
			modal:true,
			title:'详细答案',
			minimizable:false,
			maximizable:false,
			collapsible:false,
		})
		
		$('#detail_tables').datagrid({
			fit : true,
			method : 'post',
			url : '${pageContext.request.contextPath}/answer/getStudentAnswerTable.xhtml',
			queryParams:{exam_id:exam_id,student_id:student_id},
			iconCls : 'icon-ok',
			rownumbers : true,
			fitColumns : true,
			//toolbar : '#extToolbar',
			singleSelect : true,
			idField : 'userId',
			nowrap : false,
			striped : true,
			remoteSort : false,
			pagination : true,
			loadMsg:'数据加载中,请稍等...',
			rowStyler : function(index, row) {
			},
			pageSize : 15,
			pageList : [ 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 ],
			frozenColumns : [ [ {
				field : 'exam_id',
				checkbox : true
			} ] ],
			columns : [ [  {
				field : 'name',
				width : 100,
				title : '学生姓名'
			},{
				field : 'exam_identity',
				width : 100,
				title : '试卷编号',
			
			}, {
				field : 'question',
				width : 100,
				title : '问题'
			}, {
				field : 'answer',
				width : 100,
				title :'答案'
			}] ]
		})
		
		
		$('#detail_tables_question').datagrid({
			fit : true,
			method : 'post',
			url : '${pageContext.request.contextPath}/answer/getStudentAnswerTableQuestion.xhtml',
			queryParams:{exam_id:exam_id,student_id:student_id},
			iconCls : 'icon-ok',
			rownumbers : true,
			fitColumns : true,
			//toolbar : '#extToolbar',
			singleSelect : true,
			idField : 'userId',
			nowrap : false,
			striped : true,
			remoteSort : false,
			pagination : true,
			loadMsg:'数据加载中,请稍等...',
			rowStyler : function(index, row) {
			},
			pageSize : 15,
			pageList : [ 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 ],
			frozenColumns : [ [ {
				field : 'exam_id',
				checkbox : true
			} ] ],
			columns : [ [  {
				field : 'name',
				width : 100,
				title : '学生姓名'
			},{
				field : 'exam_identity',
				width : 100,
				title : '试卷编号',
			
			}, {
				field : 'question_name',
				width : 100,
				title : '标题'
			}, {
				field : 'question_content',
				width : 100,
				title : '问题'
			}, {
				field : 'answer',
				width : 100,
				title :'答案'
			}] ]
		})
		
		
	}
	
</script>

</html>