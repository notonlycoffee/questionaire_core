<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="userinfo" style="background-image:url(${ctx}resources/images/index_header_bg.png);width:100%;height:65px;">
	
	<div style="float:right;margin:25px 20px 0 0;">
	欢迎您,&nbsp;&nbsp;<span style="font-weight:bolder;">${user.name }</span> &nbsp;&nbsp;
	
	<a style="text-decoration:none;" class="easyui-linkbutton" href="${pageContext.request.contextPath }/logout.xhtml">[退出]</a>&nbsp;&nbsp;
	<a href="javascript:void(0)" onclick="changepassword();" class="easyui-linkbutton">[修改密码]</a>
	</div>
</div>

<div id="changepasswordinnorth"></div>



<script>
	function changepassword() {
		alert("亲,还不想做,啊哈哈哈");
	}
</script>