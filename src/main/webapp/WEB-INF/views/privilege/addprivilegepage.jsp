<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div>
	
	<div style="width:250px;margin:auto;position: relative;top:50px;" >
		<input id="pri_name" type="text" name="name" placeholder="请输入权限名称" style="width:230px;height:30px;" /> <br /> <br />
		
	</div>
	
	<div style="position: absolute;bottom:40px;right:20px;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addPrivilegeSure();">确定</a>&nbsp;&nbsp;
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="daddPrivilegeCacel();">取消</a>
	</div>
</div>