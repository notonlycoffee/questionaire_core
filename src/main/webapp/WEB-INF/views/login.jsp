<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<jsp:include page="/include.xhtml"></jsp:include>
<style>
	#contains_all {width:400px;height:300px;text-align:center;margin:100px auto;border:solid 1px red;}
	#login_div {margin-top:30px;}
	.input_text {width:250px;height:30px;margin-top:20px;}
	#submit_bu{cursor:pointer;}
	#cc {width:100px;height:25px;cursor:pointer;}
	#dd{margin-top:200px;}
</style>
</head>
<body>

	<div id="contains_all" >
		<div id="login_div">
			<span>用户登陆</span>
			<hr style="width:370px;"/>
			<br /><br />
			<form action="${pageContext.request.contextPath }/login.xhtml" method="post">
				
				<input style="width:250px;height:30px;" id="dd" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入账号'"  name="username"> <br /><br />
				<input style="width:250px;height:30px;" class="easyui-textbox" data-options="iconCls:'icon-lock',prompt:'请输入密码',type:'password'" name="password" > <br /><br />
				
				<input id="cc" />  
				<input type="hidden" name="userroleid" id="roleidvalue" value="fff" />
				<br /><br />
				<input id="submit_bu" class="input_text" type="submit" value="登陆" />
				
				
			</form>
		</div>
	</div>

	
	<script type="text/javascript">
	
	
	
	 $('#cc').combobox({
		url:'${pageContext.request.contextPath }/getAllRole.xhtml',
		valueField:'id',
		textField:'text',
		panelHeight:'auto',
		onSelect:function(param) {
			console.log(param);
			$('#roleidvalue').val(param.id);
		}
	});
	
	
	
	
	$('#roleidvalue').val($('#cc').combobox("getValue"));
	 
	
	
	
	/* $.ajax({
		type: 'get',
		data: 'username=kk',
		url:'${pageContext.request.contextPath }/getAllRole.xhtml',
	    async:false,
	    cache: false,
	    dataType:'json',
	    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		timeout : 30000,
	    success:function(result){
	    	console.log(result);
	    }
	}); */

	</script>
</body>
</html>