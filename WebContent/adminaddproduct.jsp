<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="com.bean.Light" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" >
<title>新建会议</title>
<link rel="stylesheet" type="text/css" href="Assets/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="Assets/css/thems.css">
<script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(function(){
	//自适应屏幕宽度
	window.onresize=function(){ location=location }; 
	
	var main_h = $(window).height();
	$('.hy_list').css('height',main_h-45+'px');
	
	var main_w = $(window).width();
	$('.xjhy').css('width',main_w-40+'px');
	
	
	$(".tabBox .tabCont:first").css("display","block");
	$(".tabBox .tabNav li").click(function(){
		$(this).siblings("li").removeClass("now");
		$(this).addClass("now");
		$(this).parents(".tabBox").find(".tabCont").css("display","none");
		var i=$(this).index();
		$(this).parents(".tabBox").find(".tabCont:eq("+i+")").css("display","block");
	});
	
	$('.xial_m span').click(function(){
		$(this).parent('.xial_m').siblings('.xl_ctn').toggle();
	});
});
</script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
	<div class="right_m">
		<!--会议列表-->
        <div class="hy_list">
        	<div class="box_t">
            	<span class="name">新建会议</span>
                <!--当前位置-->
                <div class="position">
                	<a href=""><img src="Assets/images/icon5.png" alt=""/></a>
                    <a href="">首页</a>
                    <span><img src="Assets/images/icon3.png" alt=""/></span>
                    <a href="">会议管理</a>
                    <span><img src="Assets/images/icon3.png" alt=""/></span>
                    <a href="">会议列表</a>
                </div>
                <!--当前位置-->
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--新建会议-->
            <form action="" method="post">
            <div class="xjhy" style="padding:0px;">
                <div class="tabBox_t">
                    <div class="tabBox">
                      <ul class="tabNav">
                        <li class="now"><span>基本配置</span></li>
                        
                      </ul>
                        <div class="tabCont" style="display:block;">
                        <!--基本配置--><form action="adminaddclock.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr>
<td>类别</td>
<td><!-- <input type="text" name="clocktype"></td> -->
	                                <select name="clocktype">
	                                	<option value="0">请选择</option>
	                                    <c:forEach items="${clocktypes}" var="clock">
	                                    	<option value="${clock.typeid}">${clock.typename}</option>
	                                    </c:forEach>
	                                </select>
	                            </td>     </tr>
<tr>
<td>name</td>
<td><input  name="name" type="text"></td>
</tr>	 
<tr>
<td>price</td>
<td><input  name="price" type="text"></td>
</tr>    
<td>img</td>
<td><input name="imgs" type="file"></td>
</tr>   
<tr><td colspan="2"><input type="submit"></td></tr>                                                   
</table></form>
                        <!--基本配置-->
                        </div>
                       
                	</div>
                </div>
            </div>
            </form>
            <!--新建会议-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>
