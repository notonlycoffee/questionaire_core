<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理</title>
<jsp:include page="/include.xhtml"></jsp:include>
</head>
<body>
	
	<div style="width:350px;margin:0 auto;margin-top:70px;">
	<h1 style="font-size:20px;">选择题添加</h1>
	<br /><br /><br />
		
			<textarea rows="5" cols="50" style="resize:none" id="question" placeholder="题目名称:&nbsp;&nbsp;题目&nbsp;&nbsp;例子:你确定辛勤劳动一定能够获得结果?"></textarea><br /><br />
			<textarea rows="3" cols="50" style="resize:none" id="select" placeholder="多个选项格式为:&nbsp;&nbsp;序号+选项+##&nbsp;&nbsp;例子:1确认##2取消##3一般##4不确定"></textarea><br /><br />
			<select id="question_type" style="cursor:pointer;position:relative;top:0;left:200px;" value="选择类型">
				<option selected="selected" value="0">单选</option>
				<option value="1">双选</option>
			</select>
			<br /><br />
			<a href="javascript:void(0);" class="easyui-linkbutton" onclick="addchoice()" >添加</a>
	</div>
	
</body>

<script>

	function addchoice() {
		var question = $('#question').val();
		var select = $('#select').val();
		var question_type = $('#question_type').val();
		
		console.log(question);
		console.log(select);
		console.log(question_type);
		
		if(question == "" || $.trim(question) == "" || select == "" || $.trim(select) == "" || question_type == "" || $.trim(question_type) == "") {
			alert("请完整填写");
			return;
		} else {
			$.ajax({
				url:'${pageContext.request.contextPath}'+'/choice/addChoice.xhtml',
				type:'post',
				data:{'question':question,'select':select,'question_type':question_type},
				success:function(data) {
					alert(data.message);
					$('#question').val("")
					$('#select').val("")
				}
			})
		}
	}

</script>

</html>