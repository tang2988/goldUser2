<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Lineitem.jsp' starting page</title>
    
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
    	<td><table width="1000px">
        	<tr>
            	<td><%@include file="homepage.jsp" %></td>
            </tr>
            
        </table></td>
       	<tr>
   		  <td colspan="2"><table>
            	<tr>
                	<td><%@include file="Order.jsp" %></td>
                </tr>
                
            </table></td>
       </tr>
       	
       	  <td><table width="1000px">
                <tr>
                <td style="font-size:16px">订单详情</td>
                <td>剩余支付时间</td>
                </tr>
                  <tr>
                       <td>交易单号${orderinformation.orderId}</td>
                       <td>下单时间${orderinformation.orderTime}:</td>
                       <td>支付时间:${orderinformation.timeofpayment}</td>
                  </tr>
                  <tr>
                  	<td>商品名称</td>
                    <td>克重(克)</td>
                    <td>单价(元)</td>
                    <td>数量(件)</td>
                    <td>小计(元)</td>
                  </tr>
               	  <tr>
                  	<td>${productinformation.productName}</td>
                    <td>${productinformation.gramWeight}</td>
                    <td>${productinformation.productPrice}</td>
                    <td>${orderinformation.quantity }</td>
                    <td>${orderinformation.orderAmount}</td>
                  </tr>  
          </table></td>
    
    <tr>
    	<td><table width="1300px">
        	<tr>
            	<td>配送物流:${orderinformation.distributioncompany }</td>
                <td>运费:0元</td>
            </tr>
            <tr>
            	<td>收货信息:${address.userName}</td>
            	<td>${address.mobilePhone}</td>
            	<td>${address.detailedAddressStreet}</td>
                <td>加工费：0元</td>
            </tr>
            <tr>
            	<td>发票信息:${orderinformation.invoiceInformation}</td>
                <td>商品金额：${orderinformation.orderAmount}</td>
            </tr>
        	<tr>
            	<td>备注:${orderinformation.remark}</td>
            </tr>
        </table></td>
    </tr>
    <tr>
    	<td><table>
        	<tr>
            	<td><a href="shopping/123">返回</a></td>
                <td><a href="#">去支付</a></td>
            </tr>
        </table></td>
    	
    </tr>
</table>
</body>
</html>
