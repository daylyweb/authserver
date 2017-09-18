<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html style="font-size:15px;">
	<head>
		<title>小只WEB-用户登录</title> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<meta http-equiv="Pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache"> 
		<meta http-equiv="Expires" content="0"> 
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="css/login/style.css" />
		<style type="text/css">
			@media screen and (orientation : landscape ){
				.login{
					margin-top:2%;
				}
			}
		
		</style>
	</head> 
	<body> 
		<div class="login">
			<div class="message">小只路由WEB验证系统-登录</div>
			<hr class="hr14"></hr>
			<form action="login" method="post" autocomplete="on">
				<input type="hidden" name="gw_address" value="${gw_address}">
				<input type="hidden" name="gw_port" value="${gw_port}">
				<input type="hidden" name="gw_id" value="${gw_id}">
				<input name="username" placeholder="用户名/邮箱" required="required" type="text" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"/>
				<hr class="hr14">
				<input name="password" placeholder="密码" required="required" type="password" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"/>
				<hr class="hr14">
				<input value="登录" style="width:100%;" type="submit" />
				<hr class="hr18">
				<a href="regist" style="float:right;font-size:15px;">新用户注册</a>
				<a href="#" style="float:left;font-size:15px;">忘记密码</a>
			</form>
		</div>
		<div class="copyright"><a href="<%=basePath %>" target="_blank">@小只WEB </a>©用户登录页</div>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">
			alert("注册一下就能上网啦！有问题加我QQ925673945！");
		</script>
	</body>
</html>