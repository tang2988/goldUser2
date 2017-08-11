<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'home.jsp' starting page</title>

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

	<table align="center">

		<tr>
        	<td>
            	<%@include file="homepage.jsp" %>
            </td>
        </tr>
		<tr>
			<td><table>
					<tr>
						<td><%@include file="Order.jsp" %></td>
						<td>
							<h2>资产总额</h2>
							<dl>
								<dt>资产总额(元)昨天总收益(元) 累计收益(元) 冻结资金(元)00.00</dt>
								<dd>${ac.accountbalance},${ac.accountbalance},${ac.accumulatedIncome},${ac.frozenCapital}</dd>
							</dl>
						</td>
					</tr>
				
				</table></td>
				
				
		</tr>
		<tr>
			<td><table style="margin-left:100px">
				<tr>
				
					<td><h2>现金账户</h2>
							<dl>
								<dt>账户余额(元)${ac.accountbalance}</dt>
							</dl> <input type="button" value="转入金荷包生意" /> <a href="topp/">充值</a><br/><a href="withtx/tixian.do">提现</a>
					</td>	
					<td><h2>黄金资产</h2>
									<dl>
									<dt>黄金克数(克)黄金现值(元)</dt>
									<dd>00.0000.00</dd>
									</dl>
						</td>
				</tr>
			</table></td>
		</tr>
		
		<tr>
			<td><table style="margin-left:100px">
				<tr>
					<td>
					<h2>最新订单 <span style="font-size: 12px"><a href="#">查看全部</a></span></h2>
					</td>
				</tr>
				<tr>
				<td>
						订单编号：下单时间
				</td>
				</tr>
			</table></td>
		</tr>
	</table>
</body>
</html>
