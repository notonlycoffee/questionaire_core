<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<style>
	.link_sub {
		text-decoration: none;
		background:#EF9A9A;
		color:#000;
		padding:5px 9px;
		border-radius:5px;
	}
</style>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div style="position:relative;top:70px;left:60px;" data-options="region:'center',border:false" title="" style="overflow: auto; padding: 10px;">
		
		<table cellpadding="15">
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
			<!-- <tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td></td><td style="width:20px;"><a style="margin-left:80px;" class="link_sub" href="javascript:void(0)" onclick="addUser();">确认</a>&nbsp;<a class="link_sub" href="javascript:void(0);"onclick="caceladd();">取消</a></td>
			</tr> -->
		</table>
		
	</div>
</div>
