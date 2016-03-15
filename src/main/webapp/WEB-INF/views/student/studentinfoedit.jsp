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
 			<p style="font-size:20px;font-weight:bolder;">学生个人信息录入</p>
 			<form action="${pageContext.request.contextPath }/studentoperation/studentinfoall.xhtml"  method="post">
 				<input type="hidden" name="id" value="${user.id }" />
 				<input type="hidden" name="ability_id" value="${user.ability_id }" />
		 		<table>
		 			<tr>
		 				<th>姓名</th>
		 				<td><input  class="input_style" type="text" name="name" value="${user.name }" /></td>
		 				<th>性别</th>
		 				<td><input  class="input_style" type="text" name="sex" value="${user.sex }" /></td>
		 			</tr>
		 			<tr>
		 				<th>学号</th>
		 				<td><input  class="input_style" type="text" name="num" value="${user.num }" /></td>
		 				<!-- <th>出生年月</th>
		 				<td><input  class="input_style" type="text" name="" /></td> -->
		 			</tr>
		 			<tr>
		 				<th>QQ</th>
		 				<td><input  class="input_style" type="text" name="qq" value="${user.qq }" /></td>
		 				<th>专业</th>
		 				<td><input  class="input_style" type="text" name="majorstr" value="${user.majorstr }" /></td>
		 			</tr>
		 			<tr>
		 				<th>手机(短号)</th>
		 				<td><input  class="input_style" type="text" name="mobile" value="${user.mobile }" /></td>
		 				<th>家庭所在地</th>
		 				<td><input  class="input_style" type="text" name="address" value="${user.address }" /></td>
		 			</tr>
		 			<tr>
		 				<th>家庭经济(贫困,一般,良好,富裕)</th>
		 				<td><input  class="input_style" type="text" name="rich_poor" value="${user.rich_poor }" /></td>
		 				<th>家庭人口/人</th>
		 				<td><input  class="input_style" type="text" name="people" value="${user.people }" /></td>
		 			</tr>
		 			<tr>
		 				<th>家庭教育情况</th>
		 				<td colspan="3" ><textarea style="resize:none;" name="family_education" placeholder="硕士以上___人，本科___人，专科______人"  rows="5" cols="50">${user.family_education }</textarea></td>
		 			</tr>
		 			<tr>
		 				<th>家人职业</th>
		 				<td colspan="3" ><textarea style="resize:none;" name="family_work" rows="5" cols="50">${user.family_work }</textarea></td>
		 			</tr>
		 			<tr>
		 				<th>爱好</th>
		 				<td><textarea style="resize:none;" rows="5" cols="25" name="hoby" >${user.hoby }</textarea></td>
		 				<th>优点</th>
		 				<td><textarea style="resize:none;" rows="5" cols="25" name="advantage">${user.advantage }</textarea></td>
		 			</tr>
		 			<tr>
		 				<th>特长</th>
		 				<td><textarea style="resize:none;" rows="5" cols="25" name="specialty" >${user.specialty }</textarea></td>
		 				<th>缺点</th>
		 				<td><textarea style="resize:none;" rows="5" cols="25" name="shortcoming">${user.shortcoming }</textarea></td>
		 			</tr>
		 			
		 			
		 			<tr></tr>
		 			<tr>
		 				<td colspan="3"></td>
		 				<td>
		 				
		 				</td>
		 			</tr>
		 		</table>
		 		
		 		<table border="1">
		 			<tr>
					  <th rowspan="5" style="width:200px;">硬实力</th>
					  <th style="width:150px; height:40px;">学业成绩</th>
					  <td style="width:250px; height:40px;"><textarea rows="2" cols="45" style="resize:none" name="score">${ability.score }</textarea></td>
					</tr>
					<tr>
					  	<th style="height:40px;">专业技能能力</th>
					  	<td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="major_ability">${ability.major_ability }</textarea></td>
					  </tr>
					  <tr>
					  	<th style="height:40px;">外语能力</th>
					  	<td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="foreign_language">${ability.foreign_language }</textarea></td>
					  </tr>
					  <tr>
					  	<th style="height:40px;">其他能力</th>
					  	<td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="other_ysl">${ability.other_ysl }</textarea></td>
					  </tr>
					  <tr>
					  	<th style="height:40px;">获奖情况</th>
					  	<td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="reward">${ability.reward }</textarea></td>
					  </tr>
					  
					  <tr>
					  <th rowspan="5">软实力</th>
					  <th style="height:40px;">人格品质修养</th>
					  <td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="rgpzxy">${ability.rgpzxy }</textarea></td>
					</tr>
					<tr>
					  	<th style="height:40px;">身心健康调节</th>
					  	<td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="sxjktj">${ability.sxjktj }</textarea></td>
					  </tr>
					  <tr>
					  	<th style="height:40px;">沟通交际能力</th>
					  	<td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="gtjjnl">${ability.gtjjnl }</textarea></td>
					  </tr>
					  <tr>
					  	<th style="height:40px;">文体活动能力</th>
					  	<td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="wthdnl">${ability.wthdnl }</textarea></td>
					  </tr>
					  <tr>
					  	<th style="height:40px;">其他能力</th>
					  	<td style="height:40px;"><textarea rows="2" cols="45" style="resize:none" name="other_rsl">${ability.other_rsl }</textarea></td>
					  </tr>
		 		</table>
		 		
		 		<input type="submit" value="提交" style="width:80px;height:30px;cursor:pointer; margin:20px 0 0 300px;" />
		 		
		 	</form>
 		</div>
 	</div>
 </div>
	
</body>

<script>
</script>

</html>