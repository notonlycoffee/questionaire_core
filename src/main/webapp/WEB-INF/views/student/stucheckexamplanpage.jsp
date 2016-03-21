<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生查看问卷计划</title>
<jsp:include page="/include.xhtml"></jsp:include>
</head>

<body>
	
	<div style="height:300px;">
		<table id="dg"></table>
	</div>
	
	
</body>

<script>


$(function() {
	loadallexamplan();
})

function loadallexamplan() {
	$('#dg').datagrid({

		fit : true,
		method : 'post',
		url : '${pageContext.request.contextPath}/exam/getAllExamPlanOpen.xhtml',
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
			field : 'exam_id',
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
		}, {
			field : 'status',
			width : 100,
			title : '试卷状态',
			formatter:function(value,row,index) {
				if(row.status == "开放") {
					return "<span style='background:#EF9A9A;padding:5px;'>"+row.status+"</span>";
				} else {
					return "<span style='padding:5px;'>"+row.status+"</span>";
				}
				
			},
		},{
			field:'dddd',	
			width:100,
			title:'填写问卷',
			formatter:function(value,row,index) {
				var id = row.exam_id;
				return "<a style='color:#3385FF' href='javascript:void(0)' onclick=\"writeexam('"+id+"');\">填写问卷</a>"
			}
		}
		] ]
	})	
}

function writeexam(exam_id) {
	var node = {text:"填写问卷",attributes:{url:"/studentexam/getOpenExam.xhtml?exam_id="+exam_id},url:"hh.xhtml"};
	self.parent.addTab(node);
	
}

</script>
</html>