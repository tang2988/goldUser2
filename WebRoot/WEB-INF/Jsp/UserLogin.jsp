<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'UserLogin.jsp' starting page</title>

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
    jQuery.validator.addMethod("mobliePhone_rule", function(value, element) { 
    	var mobliePhone = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
    	return mobliePhone.test(value); 
    	},"手机号码格式错误");
    
    jQuery.validator.addMethod("password_rule", function(value, element) {
    	var password = /^([a-zA-Z0-9]+){6,20}$/;
    	return password.test(value);
    	}, "只能输入数字和字母(6位到10位)");
    
    $("form").validate({
    	rules: { 
    		        mobliePhone:{
    		        	mobliePhone_rule:true,
    		        },
    		        password:{
    					password_rule:true,
    					
    				}
    	}
    });
});
</script>

<body>
	<form action="userlogin/userlogin.do" method="post" id="myform">
		<table width="750" align="center" border="1">
			<tr>
				<td ><table>
						<tr>
							<td colspan="2"></td>
							<td >没有账户?<a href="userlogin/Register.do">立即注册</td>
						</tr>
						<tr>
							
							<td>请输入手机号码:<input type="text" name="mobliePhone"
								maxlength="11" id="mobliePhone" required /></td>
						</tr>
						<tr>
							<td>请输入登录密码:<input type="password" name="password"
								id="password" required /></td>
						</tr>
						<tr>
							<td><input type="checkbox" name="checkbox" value="" />记住我</td>

						</tr>
						<tr>
							<td><input type="submit" value="登录"></td>

						</tr>
						<td><hr></td>

					</table></td>
			</tr>

		</table>
	</form>
</body>
</html>
