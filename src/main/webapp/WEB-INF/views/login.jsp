<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<style>
	#contains_all {width:400px;height:300px;text-align:center;margin:150px auto;border:solid 1px red;}
	#login_div {margin-top:40px;}
	.input_text {width:250px;height:30px;margin-top:20px;}
	#submit_bu{cursor:pointer;}
</style>
</head>
<body>

	<div id="contains_all" >
		<div id="login_div">
			<span>用户登陆</span>
			<hr style="width:370px;"/>
			<form action="${pageContext.request.contextPath }/login.xhtml" method="post">
				<input class="input_text" placeholder="请输入用户名" type="text" name="username" value="" /><br />
				<input class="input_text" placeholder="请输入密码" type="password" name="password" value="" /><br />
				<input id="submit_bu" class="input_text" type="submit" value="登陆" />
			</form>
		</div>
	</div>

	
	

</body>
</html>