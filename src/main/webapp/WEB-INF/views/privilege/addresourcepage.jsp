<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div>
	
	
	<div style="width:250px;margin:auto;position: relative;top:50px;" >
		<input id="resourcename" type="text" name="name" placeholder="请输入资源名称" style="width:230px;height:30px;" /> <br /> <br />
		<input id="resourcepath" type="text" name="path" placeholder="请输入资源路径" style="width:230px;height:30px;" /> <br /> <br />
		<input id="cc" name="userroleid" style="width:100px;" /> <br />
	</div>
	
	<div style="position: absolute;bottom:40px;right:20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="doResource.addResourceSure();">确定</a>&nbsp;&nbsp;
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="doResource.addResourceCacel();">取消</a>
	</div>
</div>

<script>
	$(function(){
		$('#cc').combobox({
			url:'${pageContext.request.contextPath }/resourcemanage/getAllPrivilege.xhtml',
			valueField:'id',
			textField:'text',
			panelHeight:'auto',
			onSelect:function(param) {
			}
		});
		
	});
	
</script>