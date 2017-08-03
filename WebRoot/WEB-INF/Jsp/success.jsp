<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    ${xg}<a href="userpwd/userpwdd.do">返回</a>
    ${uo}<a href="userpwd/userpwdd.do">返回</a><br/>
    ${tj}<a href="usercard/user.do">返回</a>
   
    ${tx}<a href="withtx/tixian.do">返回提现页面</a>
    ${cz}<a href="topp/top.do">返回充值页面</a>
    ${aa}<a href="confirm/confirm.do"></a>
  </body>
</html>
