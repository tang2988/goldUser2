<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
a{
	text-decoration:none;
	color:#000;
	
};
</style>
</head>

<body>
<table>
	<tr>
    	<td><table width="800px">
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
</table>
</body>
</html>
