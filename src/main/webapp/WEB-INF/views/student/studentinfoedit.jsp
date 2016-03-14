<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理</title>
<jsp:include page="/include.xhtml"></jsp:include>
<style type="text/css">
	.input_style {
	width:180px;
	height:30px;
	}
</style>
</head>
<body>

 <div>
 	<div id="contain" style="overflow:scroll;height:500px;">
 		<div style="width:800px;margin:0 auto;">
 			<form action="${pageContext.request.contextPath }/studentoperation/studentinfoall.xhtml"  method="post">
		 		<table>
		 			<tr>
		 				<th>姓名</th>
		 				<td><input  class="input_style" type="text" name="name" /></td>
		 				<th>性别</th>
		 				<td><input  class="input_style" type="text" name="sex" /></td>
		 			</tr>
		 			<tr>
		 				<th>学号</th>
		 				<td><input  class="input_style" type="text" name="num" /></td>
		 				<!-- <th>出生年月</th>
		 				<td><input  class="input_style" type="text" name="" /></td> -->
		 			</tr>
		 			<tr>
		 				<th>QQ</th>
		 				<td><input  class="input_style" type="text" name="qq" /></td>
		 				<th>专业</th>
		 				<td><input  class="input_style" type="text" name="majorstr" /></td>
		 			</tr>
		 			<tr>
		 				<th>手机(短号)</th>
		 				<td><input  class="input_style" type="text" name="mobile" /></td>
		 				<th>家庭所在地</th>
		 				<td><input  class="input_style" type="text" name="address" /></td>
		 			</tr>
		 			<tr>
		 				<th>家庭经济(贫困,一般,良好,富裕)</th>
		 				<td><input  class="input_style" type="text" name="rich_poor" /></td>
		 				<th>家庭人口/人</th>
		 				<td><input  class="input_style" type="text" name="people" /></td>
		 			</tr>
		 			<tr>
		 				<th>家庭教育情况</th>
		 				<td colspan="3" ><textarea style="resize:none;" name="family_education" placeholder="硕士以上___人，本科___人，专科______人" name="" rows="5" cols="50"></textarea></td>
		 			</tr>
		 			<tr>
		 				<th>家人职业</th>
		 				<td colspan="3" ><textarea style="resize:none;" name="family_work" rows="5" cols="50"></textarea></td>
		 			</tr>
		 			<tr>
		 				<th>爱好</th>
		 				<td><input  class="input_style" type="text" name="hoby" /></td>
		 				<th>优点</th>
		 				<td><input  class="input_style" type="text" name="advantage" /></td>
		 			</tr>
		 			<tr>
		 				<th>特长</th>
		 				<td><input  class="input_style" type="text" name="specialty" /></td>
		 				<th>缺点</th>
		 				<td><input  class="input_style" type="text" name="shortcoming" /></td>
		 			</tr>
		 			
		 			<tr></tr>
		 			<tr>
		 				<td colspan="3"></td>
		 				<td>
		 				<input type="submit" value="提交" style="width:80px;height:30px;cursor:pointer;" />
		 				</td>
		 			</tr>
		 		</table>
		 	</form>
 		</div>
 	</div>
 </div>
	
</body>

<script>
</script>

</html>