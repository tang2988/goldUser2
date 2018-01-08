<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<style type="text/css">
#content td{border: 1px solid #f0f ; text-align: center;}
</style>
</head>

<body>
	<table>
		<tr>
			<!-- 头部 -->
			<td colspan="2"><%@include file="homepage.jsp"%></td>
		</tr>
		<tr>
			<!-- 中部 -->
			<td><%@include file="Order.jsp"%></td>
			<td>
				<!-- content -->
				<div id="content">
					<table >
				<tr>
                   	<td>
                       	全部订单
                       </td>
                      
                   </tr>
	                    
				<c:if test="${fn:length(andProductVoList)<1}">
	            	<tr>
	              	    <td colspan="5">
	              	    没有订单
	              	    </td>
	              </tr>
	            </c:if>
	            
	            <c:forEach items="${andProductVoList}" var="andProductVo">
	              <tr>
	              		
	              	    <td colspan="5"><table>
	              	    	
	                    	<tr>
	                        	<td>订单编号:${andProductVo.orderId}</td>
	                            <td>下单时间:<fmt:formatDate value="${andProductVo.orderTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                        </tr>
	                        <tr>
	                        	<td>产品名称:${andProductVo.productName}<br/>
	                        	
	                        	</td>
	                        	<td>
	                        		克重${andProductVo.buyWeight}
	                        	</td>
	                        	<td>
	                        	<!--  '状态:10已下单,20已支付,30已起息,40已回款,50已取消,60已超时',
	                        	 -->
	                        		交易状态<br/>${andProductVo.orderStatusStr}
	                        		<c:if test="${andProductVo.orderStatusStr=='已下单'}">
	                        			<a href="ordersteadyprofit/CancelOrder.do?orderId=${andProductVo.orderId}">取消订单</a>
	                        		</c:if>
	                        		<c:if test="${andProductVo.orderStatusStr=='已下单'}">
	                        			<a href="ordersteadyprofit/Pay.do?orderI=${andProductVo.orderId}">支付</a>
	                        		</c:if>
	                        	</td>
	                           
	                        	<td>操作<br/><a href="ordersteadyprofit/TheOrderDetails.do?orderId=${andProductVo.orderId}">查看详情</a>
	                        	
	                        	
	                        </tr>
	                    </table></td>
	                  
	              </tr>
	                </c:forEach>
						
				
				</table>
				</div>
				
			<td>
		</tr>
		<tr>
			<!-- 底部 -->
		</tr>
	</table>
</body>
</html>
