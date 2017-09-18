<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html style="font-size:15px;">
	<head>
		<title>小只WEB-用户注册</title> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<meta http-equiv="Pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache"> 
		<meta http-equiv="Expires" content="0"> 
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="css/regist/style.css" />
		<style type="text/css">
			@media screen and (orientation : landscape ){
				.login{
					margin-top:2%;
				}
			}
		
		</style>
	</head> 
	<body> 
<!-- 		<div style="width:70%;height:100%;float:left;">
			<div style="width:100%;float:left;">
				<div style="float:left;color:rgba(1, 45, 49, 0.44);font-size:56px;margin-top:20%;margin-left:10%;">青，取之于蓝而青于蓝。</div>
				<div style="float:right;color:rgba(1, 45, 49, 0.44);font-size:56px;margin-top:10%;margin-right:10%;">冰，水为之而寒于水。</div>
			</div>
		</div> -->

		<!-- <div style="width:30%;height:100%;margin:0 auto;"> -->
				<div class="login">
				    <div class="message">小只路由WEB验证系统-注册</div>
				    <hr class="hr14"></hr>
				    <form action="regist" method="post" autocomplete="on">
						<input name="username" placeholder="用户名/邮箱" required="required" type="text" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"/>
						<hr class="hr14">
					    <input name="password" placeholder="密码" required="required" type="password" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"/>
						<hr class="hr14">
						<input value="注册" style="width:100%;" type="submit" />
						<hr class="hr18">
							<a href="login" style="float:right;font-size:15px;">老用户登录</a>
							<a href="#" style="float:left;font-size:15px;">忘记密码</a>
					</form>
				</div>
				<div class="copyright"><a href="<%=basePath %>" target="_blank">@小只WEB </a>©用户注册页</div>
		<!-- </div> -->
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">

		</script>
	</body>
</html>