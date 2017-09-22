<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'UserRegister.jsp' starting page</title>

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
    	var length = value.length; 
    	var mobliePhone = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
    	return mobliePhone.test(value); 
    	},"手机号码格式错误");
    
    jQuery.validator.addMethod("password_rule", function(value, element) {
    	var Password = /^([a-zA-Z0-9]+){6,20}$/;
    	return Password.test(value);
    	}, "只能输入数字和字母(6位到10位)");
    
    $("#resgis").validate({
    	rules: { 
    		        mobliePhone:{
    		        	//required:true,
    		        	mobliePhone_rule:true,
    		        },
    				Password:{
    					//required:true,
    					password_rule:true,
    					
    				}
    	}
    });
});
</script>


<body>
	<form action="userlogin/resgis.do" method="post" id="resgis">
		<table width=>
		<tr>
		<td><%@include file="/WEB-INF/Jsp/include/Daohang.jsp"%></td>

		</tr>

		<tr>
			<td></td>
		</tr>

		<tr>
				<td><table align="center">
						<tr>
							<td>账号注册 → 实名 → 注册完成</td>
						</tr>
						<tr>
							<td>手机号码:<input type="text" name="mobliePhone"
								id="mobliePhone" /></td>
						</tr>
						<tr>
							<td>图形验证码:<input type="text" name="Yanzhen" /></td>
						</tr>
						<tr>
							<td>请输入登录密码:<input type="text" name="Password"
								maxlength="10" /></td>
						</tr>
						<tr>
							<td>短信验证码<input type="text" name="Duanxin" /></td>
						</tr>
						<tr>
							<td><input type="checkbox" name="checkBox" value="">我已阅读并同意《用户注册协议》
							</td>
						</tr>
						<tr>
							<td><input type="submit" value="注册" /></td>
						</tr>
						<tr>
							<td>
								<p>
									第三方账户登录:<a href="#">立即登录</a>
								</p>
							</td>
							<td>已有账户？<a href="userlogin/login.do">立即登录</a>
							</td>
						</tr>
					</table></td>
			</tr>

		<tr>
			<td><img src="img/Yejiao.png" /></td>
		</tr>


	</table>

	</form>

</body>
</html>
