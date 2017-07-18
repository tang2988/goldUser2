<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserPassword.jsp' starting page</title>
    
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
    <form action="userpwd/userpwd.do" method="post">
	<table width="1000">
    	<tr>
        	<td><%@include file="123.jsp" %></td>
        </tr>
        <tr>
        	<td><table>
            	<tr>
                	<td><a href="#">账户总览</a></td>
                </tr>
                <tr><td><a href="#">黄金资产</a></td></tr>
                <tr><td><a href="#">我的订单</a></td></tr>
                <tr><td><a href="#">资金明细</a></td></tr>
                          
            </table></td>
        </tr>
        <tr>
        	<td><table style="" align="center">
            	<h2 style="margin-left:20%">密码设置</h2>
                <tr>
                	<td>登录密码</td>
                    <td>已经设置</td>
                    <td><a href="userpwd/updatepwd.do" >修改</a>
                </tr>
                <tr>
                	<td>
                    	交易密码
                    </td>
                    <td>
                    	<c:if test="${xg.transactionPwd=='' }">
	                    	未设置
                    	</c:if>
                    	<c:if test="${xg.transactionPwd!='' }">
	                    	已经设置
                    	</c:if>
                    </td>
                    <td><a href="#">设置</a></td>
                </tr>
               	<tr>
                	<td>交易密码<input type="password" name="trPassword" id="trPassword"></td></td>
                </tr>
                <tr>
                	<td>请确认交易密码<input type="password" name="qrPassword" id="qrPassword"></td>
                    
                </tr>
                <tr>
                	<td><input type="submit" value="提交"/></td>
                </tr>
                
            </table></td>
        </tr>
    </table>
</form>
  </body>
</html>
