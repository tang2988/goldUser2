<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserRealname.jsp' starting page</title>
    
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
<form action="userRealname/real.do" method="post">
	
	<table width="80%">
    	<tr>
        		<td><%@include file="123.jsp" %></td>
               
         </tr>
            <tr>
            	<td><table>
                	<tr>
                		<td width="30%"><a href="#">账户总览</a></td>
                    </tr>
                    <tr>
                    	<td><a href="#">黄金资产</a></td>
                    </tr>
                    <tr>
                    	<td><a href="#">我的订单</a></td>
                    </tr>
                    <tr>
                    	<td><a href="#">资金明细产</a></td>
                    </tr>
                   
              </table></td>
              
              	 
              	 <td><table>
                	<h2>实名认证</h2>
                 	<tr>
                   	 	<td>请输入姓名<input type="text" name="realName" id="realName"/>
                 		</td>
                   	</tr> 
                    <tr>
                   	 	<td>请输入身份证号码<input type="text" name="CardId" id="CardId"/>
                 		</td>
                   	</tr>
                    <tr>
                   	 	<td>请输入图形验证码<input type="" name="" id=""/></td>
                 		
                   	</tr>
               	
               		
                		<td> <input type="submit" name="sub" value="提交实名认证"/></td>
               
                 </table></td>
            </tr>
           
    </table>

</form>
</body>
</html>
