<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<tr style="background-color: #0f0">
                   	<td>
                       	全部订单
                       </td>
                       <td>待支付</td>
                       <td>待收货</td>
                       <td>退款中</td>
                      	<td>已完成</td>
                   </tr>
	                    
				<c:if test="${fn:length(mapList)<1}">
	            	<tr>
	              	    <td colspan="5">
	              	    没有订单
	              	    </td>
	              </tr>
	            </c:if>
	            <c:forEach items="${mapList}" var="map">
	              <tr>
	              		
	              	    <td colspan="5"><table>
	              	    	
	                    	<tr>
	                        	<td>订单编号:${map.orderId}</td>
	                            <td>下单时间:${map.orderTime}</td>
	                        </tr>
	                        <tr>
	                        	<td>名称${map.productName}  数量 X ${map.quantity}<br/>
	                        	克重${map.gramWeight}
	                        	</td>
	                            <td>交易状态<br />05:58<br/>${map.orderStatusStr}</td>
	                        	<td>操作<br/><a href="lineitem/12?orderId=${map.orderId}">查看详情</a>
	                        	<c:if test="${map.orderStatusStr=='下单成功'}">
	                        		<a href="confirm/Pay.do?orderId=${map.orderId}">去支付</a>
	                        	</c:if>
	                        	<c:if test="${map.orderStatusStr=='已发货'}">
	                        		<a href="confirm/updateShouhuo?orderId=${map.orderId}">确认收货</a>
	                        	</c:if>
	                        	 <!-- <br/><a href="#">取消订单</a> --></td>
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
