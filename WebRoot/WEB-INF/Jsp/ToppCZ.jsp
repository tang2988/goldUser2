<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ToppCZ.jsp' starting page</title>
    
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
    <form action="topp/top.do" method="post">
	
	<table>
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
                	<h2>账户充值</h2>
                 	<tr>
						<td>账户余额${cx.accountbalance} 元</td>
					</tr>
                    <tr>
                    	<td>选择银行:
                    		<c:forEach items="${ab}" var="bk">
                    			<input type="radio" name="raid" value="${bk.banklistId}"/>
                    			<img alt src="${bk.imageUrl}"/>
                    		</c:forEach>
                    	</td>
                    </tr>  
                    <tr>
                    	<td>充值金额<input type="text" name="czmonery" /></td>
                    </tr>   
                    <tr>
                    	<td><input type="submit" value="充值" /> </td>
                    </tr>   
                 </table></td>
                 
            </tr>
           
    </table>
	
</form>
  </body>
</html>
