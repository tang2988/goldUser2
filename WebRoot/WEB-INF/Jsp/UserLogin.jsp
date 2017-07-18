<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserLogin.jsp' starting page</title>
    
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
   <form action="userlogin/userlogin.do" method="post">
	<table width="500" align="right" border="1">
    	<tr>
        	<td><table>
            	<tr>
                	<td>
                    	登录XXX
                    </td>
                    <td>没有账户?<a href="userlogin/Register.do">立即注册</td>
                </tr>
            	<tr>
                	<td>请输入手机号码:<input type="text" name="mobliePhone"  id="mobliePhone"value=""/></td>
                </tr>
                <tr>
                	<td>请输入登录密码:<input type="password" name="password" id="password"/></td>
                </tr>
                <tr>
                	<td>
                    	<input type="checkbox" name="checkbox" value=""/>记住我
                       
                    </td>
                    
                </tr>
                <tr>
                	<td><input type="submit" value="登录"></td>
                    
                </tr>
               	<td><hr></td>
            
          </table></td>
        </tr>

  </table>
</form>
</body>
</html>
