<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<ul id="tree_menu"></ul>

<script>
	$('#tree_menu').tree({
		url:'${pageContext.request.contextPath}/getTree.xhtml'
	});
	
	$('#tree_menu').tree({
		onClick: function(node){
			addTab(node);
		}
	});


</script>

 
 
