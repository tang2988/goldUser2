<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserCard.jsp' starting page</title>
    
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
  <form action="usercard/user.do" method="post">
<table align="center">
		<tr>
        	<td><%@include file="123.jsp" %></td>
        </tr>
        
		<tr>
			<td><table>
				<tr>
					<td width="20%" ><a href="#">账户总览</a><br />
                	<a href="#">黄金资产</a><br />
              		 <a href="#">我的订单</a><br />
               		 <a href="#">资金明细</a><br />
					</td>
                    
					<td>
					<h2 style="margin-left:-10%">我的银行卡</h2>
						<p>银行卡支持列表：中国银行、招商银行、中国光大银行、中国农业银行、中国工商银行、中国建设银行、交通银行、

北京银行、广发银行、中信银行、浦发银行、兴业银行、中国民生银行 
</p>
					</td>
				</tr>
				
			</table></td>
				
				<tr>
					<td><table style="margin-left:300px">
						<tr>
							<td>
                        		真实姓名：${na.realName}
                            
							</td>
                        
                        </tr>
                       	 <tr>
                        	<td>
                        		身份证号码:${na.idcardNo}
                            </td>
                        </tr>
                        <tr>
                        	<td>
                            	银行卡号<input type="text" name="CardnoId" id="CardnoId"/>
                            </td>
                        </tr>
                        <tr>
                        	<td><input type="submit" value="添加"/></td>
                        </tr>
				</tr>
			</table></td>
		</tr>
	</table>
	</form>
</body>
</html>
