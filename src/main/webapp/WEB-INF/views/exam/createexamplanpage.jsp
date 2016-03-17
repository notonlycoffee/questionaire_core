<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div>
	<div style="width:300px;margin:0 auto;">
		<br /><br />
		试卷开放时间:<input id="publishtime" type="text" class="easyui-datebox" required="required"></input>   <br /><br />
		试卷关闭时间:<input id="closetime" type="text" class="easyui-datebox" required="required"></input>  
	</div><br /><br />
	
	<div style="height:170px;">
		<table id="dg_plan"></table>
	</div>
	
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addexamplanbutton()">添加计划</a>
	
</div>

<script>

function addexamplanbutton() {
	var publishtime = $('#publishtime').datebox('getValue');
	var closetime = $('#closetime').datebox('getValue');
	var row = $('#dg_plan').datagrid('getSelected');
	
	if(publishtime == "" || $.trim(publishtime) == "" || closetime == "" || $.trim(closetime)=="") {
		parent.showWarningBox("请选择正确而日期");
		return ;
	}
	if(!row) {
		parent.showWarningBox("请选择一份试卷");
		return;
	}
	
	$.ajax({
		url:'${pageContext.request.contextPath}/exam/addExamPlanLast.xhtml',
		type:'post',
		data:{'publishtime':publishtime,'closetime':closetime,'':},
		success:function(data) {
			parent.showWarningBox(data.message);
		}
	})
	
}

$(function() {

	$('#dg_plan').datagrid({
		fit : true,
		method : 'post',
		url : '${pageContext.request.contextPath}/exam/getAllExam.xhtml',
		iconCls : 'icon-ok',
		title:'试卷列表',
		rownumbers : true,
		fitColumns : true,
		//toolbar : '#extToolbar',
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
		}] ]
	})
})
</script>
