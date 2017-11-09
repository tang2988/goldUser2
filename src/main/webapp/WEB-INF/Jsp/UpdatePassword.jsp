<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'home.jsp' starting page</title>

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
    jQuery.validator.addMethod("passwordoneRules", function(value, element) {
    	var passwordone = /^([a-zA-Z0-9]+)$/;
    	
    	return passwordone.test(value);
    	},"只能输入数字和字母(6-10位)");
    
    $("form").validate({
    	rules: {
    		
    		passwordy:{
    			required:true,
    			passwordoneRules:true,
    		},
    		
    		passwordone:{
				required:true,
				passwordoneRules:true,
				
			},
			passwordtwo: {
		        required: true,
		        minlength: 6,
		        equalTo: "#passwordone"
		      },
    	},
    	messages: {
    		
    		
			passwordtwo: {
    	        required: "请输入确认密码",
    	        minlength: "密码长度不能小于6位数",
    	        equalTo: "两次密码输入不一致"
    	      },
			
			
			passwordy:{
				required:"请输入原密码",
				
			}
    	},
    	    
    });
});
</script>
  

<body>
	
	<table align="center">
		<tr>
        	<td>
            	<%@include file="homepage.jsp" %>
            </td>
        </tr>
		<tr>
			<td><table>
					<tr>
						<td><%@include file="Order.jsp" %></td>
						<td>
							
							<!-- content -->
							 
							 <h2>修改登录密码</h2>
<div id="divv">
	<form action="userpwd/update.do" method="post" id = "fromm">
    	<table>
        	<tr>
    			<td>原登录密码<input type="text" name="passwordy" id="passwordy" /></td>
        	</tr>
            <tr>
            	<td>新的登录密码<input type="text" name="passwordone" maxlength="10" id="passwordone"  /></td>
            </tr>
            <tr>
            	<td>
                	确认登录密码<input type="text" name="passwordtwo" id="passwordtwo" maxlength="10" />
                </td>
            </tr>
            
    	</table>
      <input type="submit" value="提交" class="name1"/>
	</form>
	
</div>	 
						</td>
					</tr>
				
				</table></td>
				
				
		</tr>
	</table>
</body>
</html>
