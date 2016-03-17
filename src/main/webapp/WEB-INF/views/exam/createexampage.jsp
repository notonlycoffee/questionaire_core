<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="height:500px; overflow:scroll">
	<br /><br />
	<div >
		<p style="font-size:18px;font-weight:bolder">试卷规格</p><br /><br />
		<table border="1">
			<tr>
				<td>试卷编号</td>
				<td>试卷名称</td>
				<td>创建人</td>
				<td>试卷类型</td>
			</tr>
			<tr>
				<td><input class="input_style" type="text" id="exam_identity" value="" /></td>
				<td><input class="input_style" type="text" id="name" value="" /></td>
				<td><input class="input_style" type="text" id="author" value="${user.name }" /></td>
				<td><input class="input_style" type="text" id="type" value="未发布" /></td>
			</tr>
		</table>
		<br /><br />
		<p style="font-size:18px;font-weight:bolder;">添加试题</p><br />
		
		<p>单选题</p>
		<br /><br />
		<div style="height:400px;">
		<table id="single_choice"></table>
		</div>
		<br /><br />
		<p>多选题</p>
		<br /><br />
		<div style="height:400px;">
		<table id="multi_choice"></table>
		</div>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="createexamsure()" style="width:200px;height:40px;font-size:18px;margin-left:380px;padding:10px 0 0 80px;margin-top:20px;" >创建试卷</a>
		<br /><br />
	</div>
</div>

	<script>
	
	function createexamsure() {
		var single = $('#single_choice').datagrid('getSelections');
		var multi = $('#multi_choice').datagrid('getSelections');
		
		if(single.length != '15' || multi.length != '15') {
			parent.showWarningBox('请选择15个单选和15个多选');
			return ;
		} 
		
		var identity = $('#exam_identity').val();
		var name = $('#name').val();
		
		if(identity == "" || $.trim(identity) == "" || name == "" || $.trim(name) == "") {
			parent.showWarningBox('请完善试卷规格的填写');
			return ;
		}
		
		var single_id_str = "";
		$.each(single,function(i,e){
			single_id_str += e.id+',';
		})
		
		var multi_id_str = "";
		$.each(multi,function(i,e){
			multi_id_str += e.id+',';
		})
		
		var author = $('#author').val();
		var type = $('#type').val();
		
		$.ajax({
			url:'${pageContext.request.contextPath}/exam/addExam.xhtml',
			data:{'exam_identity':identity,'name':name,'author':author,'type':type,'single_ids':single_id_str,'mult_ids':multi_id_str},
			type:'post',
			success:function(data) {
				parent.showWarningBox(data.message);
				$('#exam_detail').window('close');
				$('#dg').datagrid('reload');
			}
			
		})			
		
	}
	
	$(function() {
		load_choice();
		load_multi_choice();
	})
	
	function load_choice() {
		$('#single_choice').datagrid({
			url:'${pageContext.request.contextPath}/exam/getAllChoice.xhtml',
			fit : true,
			method : 'post',
			iconCls : 'icon-ok',
			rownumbers : true,
			fitColumns : true,
			//toolbar : '#extToolbar',
			singleSelect : false,
			idField : 'id',
			nowrap : false,
			striped : true,
			remoteSort : false,
			pagination : true,
			loadMsg:'数据加载中,请稍等...',
			rowStyler : function(index, row) {
			},
			pageSize : 10,
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
				
			}] ]
		})
	}
	
	
	function load_multi_choice() {
		$('#multi_choice').datagrid({
		url:'${pageContext.request.contextPath}/exam/getAllMulChoice.xhtml',
		fit : true,
		method : 'post',
		iconCls : 'icon-ok',
		rownumbers : true,
		fitColumns : true,
		//toolbar : '#extToolbar',
		singleSelect : false,
		idField : 'id',
		nowrap : false,
		striped : true,
		remoteSort : false,
		//pagination : true,
		loadMsg:'数据加载中,请稍等...',
		rowStyler : function(index, row) {
		},
		pageSize : 10,
		//pageList : [ 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 ],
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
			
		}] ]
	})
	}
		
	</script>
