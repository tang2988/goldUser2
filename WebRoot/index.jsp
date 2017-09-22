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
			<td>
				<!-- 内容 -->


				<table>
					<tr>
						<td style="    padding-left: 105px;"><table width="1000px">
								<tr>
									<td>产品名称</td>
									<td>产品价格</td>
									<td>库存</td>
									<td></td>
								</tr>
								<c:forEach var="list" items="${listt}">
									<tr>
										<td>${list.productName }</td>
										<td>${list.productPrice }</td>
										<td>${list.bepertory}</td>
										<td><a href="detail/detail?productId=${list.productId}">立即购买</a></td>
									</tr>
								</c:forEach>


							</table></td>

					</tr>

					<tr>
						<!-- 媒体 -->

						<td>
							<table width="100%">
								<tr>
									<td width="50%"><img src="img/jinjia.png"></td>
									<td>
									<h1>新闻</h1>
										<table>
											
												<c:forEach var="abc" items="${media}" begin="0" end="3">
												<tr>
													<td><img src="${abc.picture}" style="width:120px;" /><br /></td>
													<td><a href="media/findByid?mediaId=${abc.mediaId}"
														title="">${abc.title}<br />${abc.content}
													</a><br />${abc.time}</td>
													</tr>
												</c:forEach>
											
										</table>

									</td>
								</tr>
							</table>
						</td>

					</tr>

					<tr>
						<!-- 合作伙伴 -->
						<td><h1>
								<a href="announ/findAll.html">合作伙伴</a>
							</h1></td>
					</tr>
					<tr>
						<!-- 合作伙伴 -->
						<td><table>
								<tr>
									<c:forEach var="abc" items="${announcementlist}" begin="0"
										end="4">
										<td><img src="${abc.imageruri}" title="${abc.title}"
											alt="${abc.title}" /></td>
									</c:forEach>
								</tr>

							</table></td>

					</tr>
				</table>


			</td>
		</tr>



		<tr>
			<td><img width="97%" src="img/Yejiao.png" /></td>
		</tr>


	</table>

</body>
</html>
