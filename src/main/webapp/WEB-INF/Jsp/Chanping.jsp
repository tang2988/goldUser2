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
					<c:forEach items="${pft}" var="pf">
						<tr>
							<td>产品编号</td>
							<td>产品类型</td>
							<td>克重</td>
							<td>品牌</td>
							<td>产品价格</td>
							<td>库存</td>
							<td>详情页</td>
							<td>产品名称</td>

							<td>状态</td>
							
						</tr>
						<tr>
							<td>${pf.productId}</td>
							<td>${pf.productType}</td>
							<td>${pf.gramWeight}</td>
							<td>${pf.brand}</td>
							<td>${pf.productPrice}</td>
							<td>${pf.bepertory}</td>
							<td>${pf.detailpage}</td>
							<td>${pf.productName}</td>
							<td>${pf.productStatus }</td>
							<td><a href="detail/detail?productId=${pf.productId}">立刻购买</a></td>

						</tr/>
					</c:forEach>

				</table></td>
		</tr>
		<tr>
			<td><table align="center">
					<tr>
						<td><a href="product/xxh?pageNo=1&pagesize=4">首页</a>
							<c:forEach begin="${beginPageNo }" step="1" end="${endPageNo}" var="g">
								<a href="product/xxh?pageNo=${g}&pagesize=4">${g }</a>
							</c:forEach> 
							<a href="product/xxh?pageNo=${pageCount}&pagesize=4">尾页</a></td>
					</tr>
				</table></td>
		</tr>



		<tr>
			<td><img src="img/Yejiao.png" /></td>
		</tr>


	</table>

</body>
</html>
