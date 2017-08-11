<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
<table width=>
	<tr>
    	<td><table width="1000px">
        	<tr>
            	<td>客服热线:4000-888-888</td>
                <td colspan="6"><a href="userlogin/Register.do">注册</a>|<a href="userlogin/login.do">登录</a></td>
            </tr>
            <tr>
            	<td>
                	<a href="#">金狮爷</a>
                </td>
                <td><a href="index.jsp">首页</a></td>
                <td><a href="#">我要买金</a></td>
                <td><a href="product/12">黄金饰品</a></td>
                <td><a href="#">安全保障</a></td>
                  <td><a href="#">关于我们</a></td>
            </tr>
            
        </table></td>
    	
    </tr>
	
</table>

</body>
</html>
