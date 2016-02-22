<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试首页</title>
</head>
<body>

	<h1>hello</h1>

	<c:forEach items="${list }" var="kk">
		${kk }
	</c:forEach>

</body>
</html>