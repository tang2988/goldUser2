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
    
    <title>My JSP 'DetailPage.jsp' starting page</title>
    
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
<form method="get" action="confirm/confirm.do">
	<table width=>
		<tr>
		<td><%@include file="/WEB-INF/Jsp/include/Daohang.jsp"%></td>

		</tr>

		<tr>
			<td></td>
		</tr>

		
        <tr>
        	<td><table align="center">
            
            	<tr>
                	<td>
                    	<input type="hidden" name="product" value="${productinformation.productId}"/>
                    </td>
                </tr>
            	
            	<tr>
            		<td>名称:${productinformation.productName }</td>
            	</tr>
            	<tr>
                	<td>价格:${productinformation.productPrice}</td>
                </tr>
                <tr>
                	<td>
                    	重量:${productinformation.gramWeight }
                    </td>
                </tr>
                <tr>
                	<td>
                    	数量:<input type="text" name="shuliang" id = "shuliang"/>
                    </td>
                </tr>
                <tr>
                	<td>
                    	服务承诺
                    </td>
                </tr>
                
                <tr>
  
                    <td>库存剩余：${productinformation.bepertory}件</td>
                </tr>
                 
                <tr>
                	 <td><input type="submit" value="立刻购买" /></td>
                </tr>
            </table></td>
        </tr>

		<tr>
			<td><img src="img/Yejiao.png" /></td>
		</tr>


	</table>
</form>
</body>
</html>