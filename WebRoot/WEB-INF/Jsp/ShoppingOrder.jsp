<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

  </head>
  
  <body>
 <table>
                	<tr>
                    	<td width="1000px" height="50px" colspan="2"><img src="http://image.so.com/v?q=图片&cmsid=ca8e1" />上午好，账户安全<%request.getParameter("mobliePhone");%></td>
                        <td>实时金价:元/克</td>
                        
                    </tr>
                    <tr>
                    	<td colspan="3"><a href="userRealname/reanl.do">实名认证</a>
                        <a href="userpwd/userpwdd.do">密码重置</a>
                       	<a href="usercard/user.do">我的22银行卡</a>
                        <a href="#">设置</a></td>
                     	
                    </tr>
               <tr>
            	<td><table>
                	<tr>
                		<td width="30%"><a href="#">账户总览</a></td>
                    </tr>
                    <tr>
                    	<td><a href="#">黄金资产</a></td>
                    </tr>
                    <tr>
                    	<td><a href="#">我的订单</a></td>
                    </tr>
                    <tr>
                    	<td><a href="#">购物订单</a></td>
                    </tr>
                    <tr>
                    	<td><a href="#">资金明细</a></td>
                    </tr>
              </table></td>
       
              	<td><table>
              		
                
              	</table></td>
            
            </tr>
              <tr>
              	    <td><table>
              	    	<tr>
                    	<td>
                        	全部订单
                        </td>
                        <td>待支付</td>
                        <td>待收货</td>
                        <td>退款中</td>
                       	<td>已完成</td>
                    </tr>
                    	<tr>
                        	<td>订单编号:${productin.productId}</td>
                            <td>下单时间:${orderinformation.orderTime}</td>
                        </tr>
                        <tr>
                        	<td>${productin.productName}</td>
                            <td>×1</td>
                            <td>交易状态<br />05:58<br/>待确认</td>
                        	<td>操作</td>
                            <td><a href="#">确认订单</a></td>
                            <td>查看详情</td>
                            <td><a href="#">取消订单</a></td>
                        </tr>
                        <tr>
                            <td>克重${productin.gramWeight}</td>
      
                        </tr>
                    </table></td>
              </tr>
               <tr>
              	    <td><table>
                    	<tr>
                        	<td>订单编号:${productin.productId}</td>
                            <td>下单时间:${orderinformation.orderTime}</td>
                        </tr>
                        <tr>
                        	<td>${productin.productName}</td>
                            <td>×1</td>
                            <td>交易状态<br />05:58<br/>待支付</td>
                        	<td>操作</td>
                            <td><a href="#">立即支付</a></td>
                            <td>查看详情</td>
                            <td><a href="#">取消订单</a></td>
                        </tr>
                        <tr>
                            <td>克重${productin.gramWeight} </td>
      
                        </tr>
                    </table></td>
              </tr>
 </table>
</body>
</html>
