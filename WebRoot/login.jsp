<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html> 
<html>
    <head>
        <title>小只WEB-用户登录</title> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta http-equiv="Pragma" content="no-cache"> 
        <meta http-equiv="Cache-Control" content="no-cache"> 
        <meta http-equiv="Expires" content="0"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style type="text/css">
            *{
                margin: 0;
                padding: 0;
            }
            form{
                width: 85%;
                margin: auto auto;
                padding-top: 10%;
            }
            body{
                background:url(images/bg.jpg);
            }
            header{
                width: 100%;
                height: 50px;
                background-color: #43a0e2;
                border-radius: 5px;
                margin: auto auto;
                padding: 5px 10px 0px 10px;
                color: #fff;
                font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
                font-size: 18px;
                text-align: center;
                line-height: 40px;
            }
            .content{
                background: #fff;
                height:350px;
                margin-top: 30%;
                border-radius: 5px;
            }
            input[type=submit]{
                background-color: #43a0e2;
                border-radius: 5px;
                width: 100%;
                height: 50px;
                border:none;
                color: #fff;
                font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
                font-size: 18px;
                margin-top: 20px;
            }
            input[type=text],input[type=password]{
                border: 1px solid #DCDEE0;
                display: inline-block;
                width: 100%;
                height: 50px;
                outline: none;
                border-radius: 3px;
                font-size: 14px;
                color: #555555;
                -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
                box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
                margin-top: 20px;
                padding-left: 20px;
            }
            footer{
            	color: #fff;
            	padding: 20px 0;
            	text-align:center;
            }
            footer>a{
            	display:inline-block;
            	width:32%
            }
            @media (min-width: 1200px){
                .content{
                    height:380px;
                }
            }
            @media screen and (orientation : landscape ) and (min-width: 667px) and (max-width: 768px){
                form{
                    padding-top: 5%;
                }
                .content{
                    height:350px;
                    margin-top: 10%;
                }
            }
            @media screen and (min-width: 428px) and (max-width: 667px){
                form{
                    padding-top: 4%;
                }
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
           <div class="row-fluid">
                <div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3  col-xs-12">
                    <div class="content">
                        <form action="login" method="post" autocomplete="on">
							<input type="hidden" name="gw_address" value="${gw_address}">
							<input type="hidden" name="gw_port" value="${gw_port}">
							<input type="hidden" name="gw_id" value="${gw_id}">
                            <header>小只路由WEB验证系统-登录</header>
                            <input name="username" placeholder="用户名/邮箱" required="required" type="text" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"/>
                            <input name="password" placeholder="密码" required="required" type="password" onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"/>
                            <input type="submit" value="登录" />
                            <footer>
                                <a href="#">忘记密码</a>
                                <a href="<%=basePath %>">@小只WEB</a>
                                <a href="regist">新用户注册</a>
                            </footer>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            window.onresize=function(){
            	var clientheight = window.innerHeight || document.body.clientHeight;
            	var dom = document.getElementsByClassName("content").item(0);
            	var cheight = dom.clientHeight;
            	if (clientheight>cheight) {
            		dom.style.marginTop=(clientheight-cheight)/2+"px";
                }
            };
            window.onload=function(){
            	alert("注册一下就能上网啦！有问题可加我QQ925673945！");
            }
        </script>
    </body>
</html>