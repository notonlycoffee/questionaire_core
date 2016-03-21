<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 这里展示试卷的具体内容 -->
<div style="height:500px; overflow:scroll">
<br /><br />
<h1 style="font-size:18px;font-weight:bolder;">选择题</h1>
<div style="height:300px;">
	<table id="choice_table"></table>	
</div>
<br /><br />
<h1 style="font-size:18px;font-weight:bolder;">解答题</h1>
<div style="height:300px;">
	<table id="question_table"></table>
</div>

<br/><br />
</div>
<script>
	var exam_id = '${exam_id }';
	$(function() {
		loadChoiceTable(exam_id);
		loadQuestionTable(exam_id);
	})

	function loadChoiceTable(exam_id) {
		$('#choice_table').datagrid({
			fit : true,
			method : 'post',
			url : '${pageContext.request.contextPath}/exam/getExamDetailChoice.xhtml',
			queryParams:{'id':exam_id},
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
				field : 'id',
				checkbox : true
			} ] ],
			columns : [ [  {
				field : 'question',
				width : 100,
				title : '问题'
			},{
				field : 'select',
				width : 100,
				title : '选项',
			}, {
				field : 'question_type',
				width : 100,
				title : '类型',
				formatter:function(value,row,index) {
					if(row.question_type =='0') {
						return "单选";
					} else return "双选";
				}
			}] ]
		});
	}
	
	function loadQuestionTable(exam_id) {
		$('#question_table').datagrid({
			fit : true,
			method : 'post',
			url : '${pageContext.request.contextPath}/exam/getExamDetailQuestion.xhtml',
			iconCls : 'icon-ok',
			rownumbers : true,
			fitColumns : true,
			queryParams:{'id':exam_id},
			//toolbar : '#extToolbar',
			singleSelect : true,
			idField : 'id',
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
				field : 'id',
				checkbox : true
			} ] ],
			columns : [ [  {
				field : 'question_name',
				width : 100,
				title : '标题'
			},{
				field : 'question_content',
				width : 100,
				title : '问题',
			}] ]
		});
	}
</script>