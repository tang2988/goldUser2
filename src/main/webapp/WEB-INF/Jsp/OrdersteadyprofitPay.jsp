<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	margin: 0;
	padding: 0
}

ul {
	list-style: none;
}

.tab {
	width: 300px;
	margin: 0 auto;
}

.tab .tab_menu {
	border: 1px solid #000000;
	height: 30px;
	width: 700px;
}

.tab .tab_menu ul li {
	float: left;
	width: 99px;
	text-align: center;
	line-height: 30px;
	border-right: 1px #333333 solid;
}

.tab .tab_menu ul li:last-child {
	border-right: none;
	width: 100px;
}

.tab .tab_menu ul li.on {
	background: #999;
}

.tab .tab_box>div {
	display: none; //
	将三个内容框架全隐藏，通过下面的: first-child属性只将第一个框架内容显示出来
}

.tab .tab_box>div:first-child {
	display: block;
}

.xxh {
	list-style: none;
	width: auto;
	text-align: center;
}
</style>
</head>

<body>
	<form id="form1" action="ordersteadyprofit/Pay.do" method="get">
	<input type="hidden" name="orderId" value="${resbo.orderId}">
	<table width=>
		<tr>
			<td><%@include file="/WEB-INF/Jsp/include/Daohang.jsp"%></td>

		</tr>

		<tr>
			<td></td>
		</tr>

		<tr>
			<td>
				<!-- 内容 -->
				<table>
					<tr>
						<td>
							<table width="1000px">
								<tr>
									<td colspan="3">订单信息</td>
									<td>实时金价</td>
									<td>剩余时间</td>

								</tr>
							</table>
						</td>
					</tr>
					
					
					<!-- 结束 -->
				</table>
			</td>
		</tr>
		
		<tr>
			<td>
			  <table>
				<tr>
						<td>
							<table width="1000px" height="100px">
								<tr>
									<td colspan="5">购入产品</td>
									<td>预期年化金息</td>
									<td>预期收益</td>
									<td>预计克重</td>
									<td>订单总额</td>
								</tr>
								
								<tr>
									<td colspan="5">${res.productName}</td>
									<td>${res.expectedAnnualizedInterestRate}%</td>
									<td>${res.profit}</td>
									<td>${res.buyWeight}</td>
									<td>${res.totalOrder}</td>
								</tr>
							</table>
						</td>
					</tr>
			
				</table>
			</td>
		
		</tr>
		
		
		<tr>
			<td>
			  <table>
				<tr>
						<td>
							<table width="1000px" height="100px">
								<tr>
									<td><input type="checkbox" name="checkbox">余额支付</td>
									<td>账户余额:${account.accountbalance}元</td>
								</tr>
								
								<tr>
									
									<td><input type="checkbox" name="checkbox">网银付款</td>
									<td></td>
								
								</tr>
							</table>
						</td>
					</tr>
			
				</table>
			</td>
		
		</tr>
		
		<tr>
			<td>
			  <table>
				<tr>
						<td>
							<table width="1000px" height="100px">
								<tr>
									
									<td colspan="5"></td>
									<td>余额支付</td>
								</tr>
								
								<tr>
									<td colspan="5"></td>
									<td>网银支付:0.0元</td>
								</tr>
								<tr>
									<td colspan="5"></td>
									<td>红包折扣:0.0元</td>
								</tr>
								<tr>
									<td colspan="5"><input type="text" name="transactionPwd">交易密码</td>
									
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		
		</tr>
		
		<tr>
			<td>
			  <table>
				<tr>
						<td>
							<table width="1000px" height="100px">
							<!--  	<tr>
									
									
									<td>交易密码:<input type="text" name="password" /></td>
									
								</tr> -->
								<tr>
									<td><input type="submit" value="付款"></td>
								</tr>
								
							</table>
						</td>
					</tr>
				</table>
			</td>
		
		</tr>
		
		
		
		
		<tr>
			<td><img width="97%" src="img/Yejiao.png" /></td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$(".tab_menu ul li").click(function() {
			$(this).addClass("on").siblings().removeClass("on"); //切换选中的按钮高亮状态
			var index = $(this).index(); //获取被按下按钮的索引值，需要注意index是从0开始的
			$(".tab_box > div").eq(index).show().siblings().hide(); //在按钮选中时在下面显示相应的内容，同时隐藏不需要的框架内容
		});
	});
    

</script>


</html>
