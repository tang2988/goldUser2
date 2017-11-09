<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UpdatePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#divv{
	margin-left:160px;
	padding:20px;
}
.name1{
	width:100px;
	margin-left:30px;
}
</style>
</head>

<body>
<h2>修改登录密码</h2>
<div id="divv">
	<form action="userpwd/update.do" method="post">
    	<table>
        	<tr>
    			<td>原登录密码<input type="password" name="password" /></td>
        	</tr>
            <tr>
            	<td>新的登录密码<input type="passwordone" name="passwordone" /></td>
            </tr>
            <tr>
            	<td>
                	确认登录密码<input type="passwordtwo" name="passwordtwo" /></td>
                </td>
            </tr>
            
    	</table>
      <input type="submit" value="提交" class="name1"/>
	</form>
	
</div>
</body>
</html>