<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<jsp:include page="/include.xhtml"></jsp:include>
<style>
	#contains_all {width:400px;height:300px;text-align:center;margin:100px auto;border:solid 1px #D7DEEA;border-radius:10px;}
	#login_div {margin-top:30px;}
	.input_text {width:250px;height:30px;margin-top:20px;}
	#submit_bu{cursor:pointer;}
	#cc {width:100px;height:25px;cursor:pointer;}
	#dd{margin-top:200px;}
</style>
</head>
<body>
	<input id="errorid" type="hidden" value="${errormessage }" />
	<div id="contains_all" >
		<div id="login_div">
			<span style="font-size:20px;font-weight:bold;">用&nbsp;户&nbsp;登&nbsp;陆</span>
			<hr style="width:370px;"/>
			
			<form style="position:relative;top:-170px;" action="${pageContext.request.contextPath }/login.xhtml" method="post">
				
				<input placeholder="请输入账号" style="width:250px;height:30px;" id="dd"  name="username"> <br /><br />
				<input type="password" placeholder="请输入密码" style="width:250px;height:30px;"  name="password" > <br /><br />
				
				<input id="cc" name="userroleid" /> <br />
				<input id="submit_bu" class="input_text" type="submit" value="登&nbsp;&nbsp;陆" />
				
			</form>
		</div>
	</div>

	
	
	<script type="text/javascript">
	
	
	
	$(function(){
		$('#cc').combobox({
			url:'${pageContext.request.contextPath }/getAllRole.xhtml',
			valueField:'id',
			textField:'text',
			panelHeight:'auto',
			onSelect:function(param) {
			}
		});
		
		
		
		var me = $('#errorid').val();
		if($.trim(me) != '') {
			alert(me);
		}
	});
	
	
	
	
	
	</script>
</body>
</html>