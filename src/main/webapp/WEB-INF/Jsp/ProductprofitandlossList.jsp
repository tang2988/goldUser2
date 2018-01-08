<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">
a {
	text-decoration: none;
	color: #000;
}
;
</style>
</head>

<body>
	<table width=>
		<tr>
			<td><%@include file="include/Daohang.jsp"%></td>

		</tr>

		<tr>
			<td></td>
		</tr>


		<tr>
			<td><table align="center">
					<c:forEach items="${product.datas}" var="vo">
						<tr>
							<td>产品编号</td>
							<td>产品名称</td>
							<td>预期年化金息</td>
							<td>活动加息</td>
							<td>产品期限</td>
							<td>起购金额</td>
							
						</tr>
						<tr>
							<td>${vo.productId}</td>
							<td>${vo.productName}</td>
							<td>${vo.expectedAnnualizedInterestRate}</td>
							<td>${vo.activityPlusInterest}</td>
							<td>${vo.productDeadline}</td>
							<td>${vo.sumofMoneyPurchaseddecimal}</td>
							<td><a href="productprof/productdetailpage?productId=${vo.productId}">立刻购买</a></td>

						</tr/>
					</c:forEach>

				</table></td>
		</tr>
		<tr>
			<td><table align="center">
					<tr>
						<td><a href="productprof/productpage.do?page=1&pagesize=3">首页</a>
							<c:forEach begin="1" step="1" end="${product.totalPages}" var="g">
								<a href="productprof/productpage.do?page=${g}&pagesize=3" >${g }</a>
							</c:forEach> 
							<a href="productprof/productpage.do?page=${product.totalPages}&pagesize=3">尾页</a></td>
					</tr>
				</table></td>
		</tr>



		<tr>
			<td><img src="img/Yejiao.png" /></td>
		</tr>


	</table>

</body>
</html>
