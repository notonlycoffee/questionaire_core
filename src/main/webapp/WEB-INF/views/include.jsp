<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<%-- <link href="${pageContext.request.contextPath}/resources/lib/easyui/themes/default/easyui.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/lib/easyui/themes/icon.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/easyui/jquery.easyui.min.js"></script>
<!-- 扩展EasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/easyui/extEasyUI.js?v=201305241046" charset="utf-8"></script>
<!-- 扩展jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/extJquery.js?v=201305301341" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/easyui/locale/easyui-lang-zh_CN.js"></script>

 --%>
 
 
 
 <link href="${pageContext.request.contextPath}/resources/lib/base.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/lib/easyui/themes/default/easyui.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/lib/easyui/themes/icon.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/easyui/jquery.easyui.min.js"></script>
<!-- 扩展EasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/easyui/extEasyUI.js" charset="utf-8"></script>
<!-- 扩展jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/extJquery.js?v=201305301341" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/easyui/locale/easyui-lang-zh_CN.js"></script>

<script>
var GLOBAL_I18N ={
			//#global
			"global_progress_title":"<spring:message code='global.progress.title'/>",
			"global_progress_text":"<spring:message code='global.progress.text'/>",
			"global_action_success":"<spring:message code='global.action.success'/>",
			"global_action_failure":"<spring:message code='global.action.failure'/>",
			"global_action_permissions":"<spring:message code='global.action.permissions'/>",
			//#global button
			"global_button_add":"<spring:message code='global.button.add'/>",
			"global_button_remove":"<spring:message code='global.button.remove'/>",
			"global_button_edit":"<spring:message code='global.button.edit'/>",
			"global_button_save":"<spring:message code='global.button.save'/>",
			"global_button_cancel":"<spring:message code='global.button.cancel'/>",
			"global_button_confirm":"<spring:message code='global.button.confirm'/>",
			"global_message_not_null":"<spring:message code='global.message.not.null'/>",
			//#global message
			"global_message_please_select_remove":"<spring:message code='global.message.please.select.remove'/>",
			"global_message_please_select_edit":"<spring:message code='global.message.please.select.edit'/>",
			"global_message_remove_ask":"<spring:message code='global.message.remove.ask'/>",
			"invalidLengthError" : "<spring:message code='global.message.invalid.length'/>",
			"adminRoleName" : "<spring:message code='global.system.role.name'/>",
			"systemError" : "<spring:message code='global.message.system.error'/>",
			"systemServerError" : "<spring:message code='global.message.system.server.error'/>",
			"gologin" : "<spring:message code='global.message.gologin'/>"
			
	};

</script>
