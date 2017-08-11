<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ToppCZ.jsp' starting page</title>
    
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
    jQuery.validator.addMethod("czmoneryRules", function(value, element) {
    	var czmonery = /^([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,2})?$/;
    	return czmonery.test(value);
    	}, "充值金额只能输入数字");
    
    
    $("form").validate({
    	rules: {
    		czmonery:{
				required:true,
				czmoneryRules:true,	
			},
			raid:{
				required:true,
			}
    	},
    	messages:{
    		raid:{
				required:"请选择方式",
			}
    		
    	}
    });
});
</script>
  
  <body>
    <form action="topp/top.do" method="post">
	
	<table>
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
                	<h2>账户充值</h2>
                 	<tr>
						<td>账户余额${cx.accountbalance} 元</td>
					</tr>
                    <tr>
                    	<td>选择银行:
                    		<c:forEach items="${ab}" var="bk">
                    			<input type="radio" name="raid" value="${bk.banklistId}"/>
                    			<img alt src="${bk.imageUrl}"/>
                    		</c:forEach>
                    	</td>
                    </tr>  
                    <tr>
                    	<td>充值金额<input type="text" name="czmonery"/></td>
                    </tr>   
                    <tr>
                    	<td><input type="submit" value="充值" /> </td>
                    </tr>   
                 </table></td>
                 
            </tr>
           
    </table>
	
</form>
  </body>
</html>
