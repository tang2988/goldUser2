<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
#content td{border: 1px solid #f0f ; text-align: center; width: 200px;}
</style>
</head>

<body>
	<table>
		<tr>
			<!-- 头部 -->
			<td colspan="2"><%@include file="/WEB-INF/Jsp/homepage.jsp"%></td>
		</tr>
		<tr>
			<!-- 中部 -->
			<td><%@include file="/WEB-INF/Jsp/Order.jsp"%></td>
			<td>
				<!-- content -->
				<h1>订单详情</h1>
				<div id="content">
					<table >
					<tr>
                      <td>产品名称:${orderProductVo.productName}</td>
                      <td>订单金价:${orderProductVo.productName}</td>
                   </tr>
                   <tr>
                      <td>交易单号:${orderProductVo.orderId}</td>
                       <td>订单总额:${orderProductVo.totalOrder}</td>
                   </tr>
                   <tr>
                      <td>下单时间:<fmt:formatDate value="${orderProductVo.orderTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                       <td>实际支付:${orderProductVo.totalOrder}</td>
                   </tr>
                   <tr>
                      <td>买入克重:${orderProductVo.buyWeight}</td>
                       <td>支付时间:<fmt:formatDate value="${orderProductVo.paymentTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                   </tr>
                   <tr>
                      <td>利率:${orderProductVo.interestRate}</td>
                       <td>起息时间:<fmt:formatDate value="${orderProductVo.interestTime}" pattern="yyyy-MM-dd" /></td>
                   </tr>
                   <tr>
                      <td>还款方式:到期一次性还本付息</td>
                       <td>到期时间:<fmt:formatDate value="${orderProductVo.ceaseDay}" pattern="yyyy-MM-dd" /></td>
                   </tr>
                   <tr>
                      <td>到期收益:${orderProductVo.profit}</td>
                       <td>支付方式:${orderProductVo.paymentMethod}</td>
                   </tr>
                   <tr>
                      <td>交易状态:${orderProductVo.orderStatusStr}</td>
                       <td>到期处理:以买入时的金价卖出，所得金额进入账户余额</td>
                   </tr>
                  	<tr>
                   		<td><a href="ordersteadyprofit/orderAndProfit"><h1>返回</h1></a></td>
                   </tr>
                   
                  
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
