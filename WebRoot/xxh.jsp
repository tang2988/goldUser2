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
</head>

<body>
	<table width=>
		<tr>
		<td><%@include file="/WEB-INF/Jsp/include/Daohang.jsp"%></td>

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
                 <td><a href="../detail/detail?productId=${pf.productId}">立刻购买</a></td>
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
                 
            
            </tr>
           </c:forEach>
        </table></td>
       </tr>

		<tr>
			<td><img src="img/Yejiao.png" /></td>
		</tr>


	</table>

</body>
</html>
