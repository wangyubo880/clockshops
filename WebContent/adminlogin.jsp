<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="Assets/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/thems.css"/>
<script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>
<!--框架高度设置-->
<script type="text/javascript">
$(function(){
	//自适应屏幕宽度
	window.onresize=function(){ location=location }; 
	
	var w_height=$(window).height();
	$('.bg_img').css('height',w_height+'px');
	
	var bg_wz=1920-$(window).width();
	$('.bg_img img').css('margin-left','-'+bg_wz/2+'px')
	
	$('.language .lang').click(function(){
		$(this).siblings('.lang_ctn').toggle();
	});
})
</script>
<!--框架高度设置-->
</head>

<body>
<!--登录-->
<div class="login">
	<div class="bg_img"><img src="Assets/images/login_bg.jpg"/></div>
	<div class="logo">
    	<a href=""><img src="Assets/images/logo.png" alt=""/></a>
    </div>
    <div class="login_m">
    	<form action="adminlogin.do" method="post">
    	<ul>
        	<li class="wz">admin name</li>
            <li><input name="adminame" type="text"></li>
            <li class="wz">password</li>
            <li><input name="password" type="password"></li>
            
            <li class="l_btn">
            	<input type="submit" value="login">
            	<a href="adminregister.jsp">Sign up</a>
            </li>
        </ul>
        </form>
    </div>
</div>
<!--登录-->
</body>
</html>
