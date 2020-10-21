<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="com.bean.Light" %>
<%@ page import="java.util.ArrayList" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" >
<title>会议列表</title>
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
	
	var search_w = $(window).width()-40;
	$('.search').css('width',search_w+'px');
	//$('.list_hy').css('width',search_w+'px');
});
</script>
<!--框架高度设置-->
</head>

<body onLoad="Resize();">
<div id="right_ctn">
	<div class="right_m">
		<!--会议列表-->
        <div class="hy_list">
        	<div class="box_t">
            	<span class="name">商品列表</span>
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
            <!--查询-->
            <div class="search"> 
            <form action="selectbyname.do" method="post">
            	<span>按名称搜索：</span>
                <div class="s_text"><input name="name" type="text"></div>
                <input type="submit" value="查询" class="btn">
                </form></div>
             <div class="search">    <form action="selectbytype.do" method="post">
            	<span>按类别搜索：</span>
                <div class="s_text"><input name="name" type="text"></div>
                <input type="submit" value="查询" class="btn">
                </form></div>
            <!--查询-->
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <form action="" method="post">
            <table cellpadding="0" cellspacing="0" class="list_hy">
              <tr >
                
                
                <th scope="col" >图片</th>
                <th scope="col">名称</th>
                <th scope="col">价格</th>
                <th scope="col">类别</th>
                <th>操作</th>
              </tr>
              <c:forEach items="${clockname}" var="clock">
              <tr>
                
                <td>${clock.img }</td>
                <td >${clock.name }</td>
                <td>${clock.price }</td>
                <td>${clock.clocktype.typename }</td>
                <td><a href="admindelete.do?id=${clock.id }">删除</a><a>修改</a></td>
              </tr>
             </c:forEach>
            </table>
            <!--列表-->
           
            <!--右边底部-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>
