<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<jsp:include page="/include.xhtml"></jsp:include>
<style>
	.link_sub {
		text-decoration: none;
		background:#EF9A9A;
		color:#000;
		padding:5px 9px;
		border-radius:5px;
	}
</style>
</head>
<body>

	<div class="easyui-layout" style="width:100%;height:500px;">
	<div  style="text-align:center;" data-options="region:'north',border:'false',height:'80'">
		
		<div style="margin:20px auto 0 auto;width:1000px;">
 		<span style="font-size:18px;color:#A9A9A9;">姓名:</span><input id="username" type="text" style="font-size:18px;height:20px;color:#A9A9A9;" /> &nbsp;&nbsp;&nbsp;&nbsp;
		<span style="font-size:18px;color:#A9A9A9;">工号(或学号):</span><input type="text" id="num" style="font-size:18px;height:20px; color:#A9A9A9;" />&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:void(0);" class="easyui-linkbutton" style="background:#EF9A9A;margin-top:-5px;width:60px;" onclick="doUser.searchUser();return false;">查&nbsp;询</a>
		</div>
		
	</div>
	<div data-options="region:'center',border:'false'">
		<table id="dg"></table>
	</div>
	
	<div id="extToolbar" style="display:none;position:relative;" >
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doUser.toAdd();return false;">新增用户</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-user',plain:true" onclick="doUser.toRole();return false;">分配角色权限</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-resetpsw',plain:true" onclick="doUser.resetPwd();return false;">重置密码</a>
	</div>
	</div>
	
	<div id="contain_add_user" style="display:none;">
	<div style="width:100%;height:100%;background:#F3F2F3;opacity:0.5;z-index:4;position:absolute;top:0;left:0;"></div>
	
	<div style="position:absolute;top:60px;left:400px;z-index:8;background:#FFF;border:solid 1px #A9A9A9;" >
		<table cellpadding="15" style="margin-top:20px;">
			<tr>
				<th>姓名</th>
				<td><input id="user_name" type="text" name="name" value="" /></td>
			</tr>
			
			<tr>
			<th>工号/学号</th>
			<td><input id="user_num" type="text" name="num" value="" /></td>
			</tr>
			<tr>
				<th>类型</th>
				<td>
					<select id="user_type">
					  <option value="学生">学生</option>
					  <option value="任课教师">任课教师</option>
					  <option value="普通教师">普通教师</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>性别</th>
				<td>
					<select id="user_sex_type">
					  <option value="男">男</option>
					  <option value="女">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input id="user_pwd" type="text" name="pwd" value="000000" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td></td><td style="width:20px;"><a style="margin-left:80px;" class="link_sub" href="javascript:void(0)" onclick="doUser.addUser();">确认</a>&nbsp;<a class="link_sub" href="javascript:void(0);"onclick="doUser.caceladd();">取消</a></td>
			</tr>
			
		</table>
	</div>
	</div>
	
	<div id="window_dia">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',width:'300',split:false" >
				<table id="roletable"></table>
			</div>
			<div data-options="region:'center',fit:true" style="overflow:scroll" >
				<ul id="privilege_tree">
				</ul>
			</div>
		</div>
	</div>
	</div>
	
	<div id="resetpassword"></div>
	
	<div id="toolbar" style="display:none;position:relative;" >
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doUser.addRole();return false;">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-user',plain:true" onclick="doUser.deleteRole();return false;">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-resetpsw',plain:true" onclick="doUser.accreditRole();return false;">授权</a>
	</div>
</body>
<script>
	var CONTEXT_PATH = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/privilege/usermanage.js"></script>
</html>