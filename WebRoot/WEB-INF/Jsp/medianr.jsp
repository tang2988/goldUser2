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

				<table width="100%">
					<tr>
						<td width="25%">
							<%@include file="/WEB-INF/Jsp/include/Gonggaomenue.jsp"%>
						</td>
						<td>
							<!-- 内容 -->
							<table>
								<tr>
									<h1>媒体报道</h1>
									<td><table>
											<tr>
												<td>${json.title}</td>
											</tr>
											<tr>
												<td>${json.noticeTimeFmt}</td>
											</tr>
											<tr>
												<td><img src="${json.picture}" style="width:220px"/></td>
											</tr>
											<tr>
												<td>${json.content}</td>
											</tr>
										</table></td>

								</tr>
							</table> <!-- 结尾 -->
						</td>
					</tr>
				</table>

			</td>
		</tr>



		<tr>
			<td><img src="img/Yejiao.png" /></td>
		</tr>


	</table>

</body>
</html>
