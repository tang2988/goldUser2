<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserPassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>

$.validator.setDefaults({       
    submitHandler: function(form) {    
        form.submit();    
   }      
});

$().ready(function() {
    jQuery.validator.addMethod("trPasswordRules", function(value, element) {
    	var trPassword = /^([a-zA-Z0-9]+)$/;
    	
    	return  trPassword.test(value);
    	},"只能输入数字和字母(6-10位)");
    
    $("form").validate({
    	rules: {
    		trPassword:{
				required:true,
				trPasswordRules:true,
				
			},
			qrPassword: {
		        required: true,
		        minlength: 6,
		        equalTo: "#trPassword"
		      },
    	},
    	messages: {
    		
    	     
    		qrPassword: {
    	        required: "请输入确认密码",
    	        minlength: "密码长度不能小于6位数",
    	        equalTo: "两次密码输入不一致"
    	      }
    	},
    	      
    });
});
</script>
  
  <body>
    <form action="userpwd/userpwd.do" method="post">
	<table width="1000">
    	<tr>
        	<td><%@include file="homepage.jsp" %></td>
        </tr>
        <tr>
        	<td><table>
            	<tr>
                	<td><%@include file="Order.jsp" %></td>
                </tr>
                          
            </table></td>
        </tr>
        <tr>
        	<td><table style="" align="center">
            	<h2 style="margin-left:20%">密码设置</h2>
                <tr>
                	<td>登录密码</td>
                    <td>已经设置</td>
                    <td><a href="userpwd/updatepwd.do" >修改</a>
                </tr>
                <tr>
                	<td>
                    	交易密码
                    </td>
                    <td>
                    	<c:if test="${xg.transactionPwd=='' }">
	                    	未设置
                    	</c:if>
                    	<c:if test="${xg.transactionPwd!='' }">
	                    	已经设置
                    	</c:if>
                    </td>
                    <td><a href="userpwd/userpwdd.do">设置</a></td>
                </tr>
               	<tr>
                	<td>交易密码<input type="password" name="trPassword" id="trPassword"  maxlength="6"></td>
                </tr>
                <tr>
                	<td>请确认交易密码<input type="password" name="qrPassword" id="qrPassword"  maxlength="6"></td>
                    
                </tr>
                <tr>
                	<td><input type="submit" value="提交"/></td>
                </tr>
                
            </table></td>
        </tr>
    </table>
</form>
  </body>
</html>
