<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserRealname.jsp' starting page</title>
    
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
	jQuery.validator.addMethod("realNameRules", function(value, element) {
		var realName = /^[\u4e00-\u9fa5]+$/;
		return realName.test(value);
		}, "只能输入中文");
    
	jQuery.validator.addMethod("CardIdRules", function(value, element) { 
		var CardId = /^\d{15}|\d{}18$/; 
		return CardId.test(value); 
		}, "身份证号码15位到18位");
    
    $("form").validate({
    	rules: { 
    		realName:{
    		        
    		        realNameRules:true,
    		       },
    		       
    		       CardId:{
    				
    				CardIdRules:true,	
    			}
    	},
    	
    });
});
</script>
  
  <body>
<form action="userRealname/real.do" method="post" >
	
	<table width="80%">
    	<tr>
        	<td><%@include file="homepage.jsp" %></td>
               
         </tr>
            <tr>
            	<td><table>
                	<tr>
                		<td><%@include file="Order.jsp" %></td>
                    </tr>
                   
              </table></td>
              
              	 
              	 <td><table>
                	<h2>实名认证</h2>
                 	<tr>
                   	 	<td>请输入姓名<input type="text" name="realName" id="realName" required/>
                 		</td>
                   	</tr> 
                    <tr>
                   	 	<td>请输入身份证号码<input type="text" name="CardId" id="CardId" required maxlength="18"/>
                 		</td>
                   	</tr>
                    <tr>
                   	 	<td>请输入图形验证码<input type="" name="" id=""/></td>
                 		
                   	</tr>
               	
               		
                		<td> <input type="submit" name="sub" value="提交实名认证"/></td>
               
                 </table></td>
            </tr>
           
    </table>

</form>
</body>
</html>
