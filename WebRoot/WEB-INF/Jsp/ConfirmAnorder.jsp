<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ConfirmAnorder.jsp' starting page</title>
    
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
<h1 align="center">确认订单信息</h1>
<form action="confirm/confirm.do" method="post">
<table  width="1000">
	<tr>
    	<td colspan="2"><table width="800">
        <h3>商品信息</h3>
        <input type="hidden" name="productId" value="${productId }"/>
        <input type="hidden" name="shuliang"  value="${shuliang }"/>
        
            <tr>
            	<td>商品名称</td>
                <td>克重</td>
                <td>单价</td>
                <td>数量</td>
                <td>小计</td>
            </tr>
        	<tr>
            	<td>${productin.productName}</td>
                <td>${productin.gramWeight }</td>
                <td>${productin.productPrice}</td>
                <td>${shuliang }</td>
                <td>${totalPrice}</td>
            </tr>
        </table></td>
    </tr>
    <tr>
    	<td colspan="2"><table width="800">
        	<h3>收货人信息</h3>
        	<tr>
            	<td><input type="text" name="name" placeholder="收件人名称"/></td>
                <td><input type=text name="mobliPhone" placeholder="收件人电话" /></td>
                <td><select name="select">
                <option>广东深圳</option>
                <option>广东非洲</option></select></td>
                <td><input type="text" name="address" placeholder="详细地址街道"/></td>                
            </tr>
        </table></td>  
    </tr>
    <tr>
    	<td colspan="2"><table>
        	<h3>发票</h3>
        	<tr>
            	<td>是否需要发票<input type="radio" name="radio"/>否</td>
                <td>是<input type="text" name="fapiao" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
    	<td colspan="2"><table>
        	<h3>配送</h3>
        	<tr>
            	<td><input value="顺丰速运" readonly="readonly" name="Kuaidi"/></td>
            </tr>
        </table></td>
    </tr>
    <tr>
    	<td colspan="2"><table width="800px">
        	<h3>备注</h3>
        	<tr>
            	<td><textarea name="Beizhu" rows="3" role="40"></textarea></td>
            </tr>
        
        </table></td>
    </tr>
    <tr>
    	<td colspan="2"><table width="800">
        	<tr>
            	<td>寄送至:${ad.userName}</td>
                <td>${ad.mobilePhone}</td>
                <td>${ad.twelveProvincesAndcities}${ad.detailedAddressStreet}</td>
                <td>运费<br/>加工费:0元<br/>商品金额：269.08元<br/>应付总额:元</td>
            </tr>
        </table></td>
    </tr>
</table>
<tr>
	<td colspan="2"><table style="margin-left:50%">
    	<tr>
        	<td><input type="submit" value="确认订单" /></td>
        </tr>
    </table></td>
</tr>
</form>
</body>
</html>
