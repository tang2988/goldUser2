<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserRegister.jsp' starting page</title>
    
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
 
	<form action="userlogin/resgis.do" method="post">
    	<table width="500" align="right" border="1">
        	<tr>
            	<td><table>
                	<tr>
                    	<td>
                        	账号注册	→ 实名 → 注册完成
                        </td>
                    </tr>
                    <tr>
                    	<td>手机号码:<input type="text" name="mobliePhone" id="mobliePhone" id="mobliePhone" />${mobliePhone }</td>
                    </tr>
                	<tr>
                    	<td>图形验证码:<input type="text" name="Yanzhen"/></td>
                    </tr>
                    <tr>
                    	<td>请输入登录密码:<input type="text" name="Password"/></td>
                    </tr>
                    <tr>
                    	<td>短信验证码<input type="text" name="Duanxin"/></td>
                    </tr>
                    <tr>
                    	<td>
                        	<input type="checkbox" name="checkBox" value="">我已阅读并同意《用户注册协议》
                        </td>
                    </tr>
                    <tr>
                    	<td>
                        	<input type="submit" value="注册"/>
                        </td>
                    </tr>
                    <tr>
                    	<td>
                        	<p>第三方账户登录:<a href="#">合时代账户</a></p>
                        </td>
                        <td>
                        	已有账户？<a href="userlogin/login.do">立即登录</a>
                        </td>
                    </tr>
                </table></td>
            </tr>
        
        </table>
    
    </form>

</body>
</html>
