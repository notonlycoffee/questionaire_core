<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生查看问卷计划</title>
<jsp:include page="/include.xhtml"></jsp:include>
</head>

<body>

<div style="height:500px;overflow:scroll;">


	<form action="${pageContext.request.contextPath }/studentexam/getStudentAnswerHot.xhtml" method="post">
	
	<input type="hidden" name="exam_id" value="${choiceList[0].exam_id }" />
	<div>
		<h1 style="font-size:20px;font-weight:bolder;margin-top:20px;">单选题</h1><br /><br />
		
		<c:forEach items="${choiceList }" var="choice" varStatus="status">
			${status.count} ${choice.question }<br /><br />
			<c:forEach items="${choice.selectList }" var="select">
					&nbsp;&nbsp;<label><input name="selectList[${status.index }]" type="radio" value="${choice.choice_id }##${select }" />${select }</label> &nbsp;&nbsp;
			</c:forEach><br /><br /><br />
		</c:forEach>
	</div>
	
	
	<div>
		<h1 style="font-size:20px;font-weight:bolder;margin-top:20px;">多选题</h1><br /><br />
		
		<c:forEach items="${multiList }" var="choice" varStatus="status">
			${status.count} ${choice.question }<br /><br />
			<c:forEach items="${choice.selectList }" var="select">
					&nbsp;&nbsp;<label><input name="multiList[${status.index }]" type="checkbox" value="${choice.choice_id }##${select }" />${select }</label> &nbsp;&nbsp;
			</c:forEach><br /><br /><br />
		</c:forEach>
	</div>
	
	
	<div>
		<h1 style="font-size:20px;font-weight:bolder;margin-top:20px;">解答题</h1><br /><br />
		
		<c:forEach var="questionMap" items="${contentMap }" varStatus="mapstatus">
			<p style="font-size:20px;font-weight:bolder;">${questionMap.key }</p>
			
			<table border="1" style="margin-left:50px;margin-top:20px;">
			
			<c:forEach var="content" items="${questionMap.value }" varStatus="status">
					<tr>
						<th>${fn:split(content,"##")[0]}</th>
						<td><textarea id="questiondd${status.index }" name="question${mapstatus.count}[${status.index}]" rows="5" cols="50" style="resize:none;"></textarea>
							<input type="hidden" name="question_id${mapstatus.count}[${status.index}]" value="${fn:split(content,"##")[1]}" />
						</td>
					</tr>
			</c:forEach>
			
			</table>
			<br /><br /><br /><br />
		</c:forEach>
		
	</div>
	
	<input style="width:100px;height:30px;font-size:18px;cursor:pointer;margin-left:500px;background:#EF9A9A;border:none;" type="submit" value="交&nbsp;卷" />
	
</form>
	`


</div>
</body>

<script>

</script>
</html>