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
    
    <title>My JSP 'ShoppingOrder.jsp' starting page</title>
    
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
 <table>
                	<tr>
                    	<td><%@include file="homepage.jsp" %></td>
                     	
                    </tr>
               <tr>
            	<td><table width="1000px">
                	
                    <tr>
                    	<td><%@include file="Order.jsp" %></td>
                    </tr>
                    
              </table></td>
       
              	<td><table>
              		
                
              	</table></td>
            
            </tr>
            <c:forEach items="${list}" var="list">
              <tr>
              		
              	    <td><table>
              	    	<tr>
                    	<td>
                        	全部订单
                        </td>
                        <td>待支付</td>
                        <td>待收货</td>
                        <td>退款中</td>
                       	<td>已完成</td>
                    </tr>
                    	<tr>
                        	<td>订单编号:${productin.productId}</td>
                            <td>下单时间:${list.orderTime}</td>
                        </tr>
                        <tr>
                        	<td>${productin.productName}</td>
                            <td>×1</td>
                            <td>交易状态<br />05:58<br/>待确认</td>
                        	<td>操作</td>
                            <td><a href="#">确认订单</a></td>
                            <td>查看详情</td>
                            <td><a href="#">取消订单</a></td>
                        </tr>
                        <tr>
                            <td>克重${productin.gramWeight}</td>
      
                        </tr>
                    </table></td>
                  
              </tr>
                </c:forEach>
            
 </table>
</body>
</html>
