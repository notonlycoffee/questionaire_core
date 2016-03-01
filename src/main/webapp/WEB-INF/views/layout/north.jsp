<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="userinfo" style="background-image:url(${ctx}resources/images/index_header_bg.png);width:100%;height:65px;">
	
	<div style="float:right;margin:25px 20px 0 0;">
	欢迎您,&nbsp;&nbsp;&nbsp;<span style="font-weight:bolder;">${user.name }</span> &nbsp;&nbsp;&nbsp;&nbsp;
	
	<a style="text-decoration:none;" href="${ctx }/logout.xhtml">[退出]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a style="text-decoration:none;" href="${ctx }/changepassword.xhtml">[修改密码]</a>
	</div>
</div>