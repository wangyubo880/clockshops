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
            
             <div class="search">    <form action="orderlistbyid.do" method="post">
            	<span>按用户id搜索：</span>
                <div class="s_text"><input name="uid" type="text"></div>
                <input type="submit" value="查询" class="btn">
                </form></div>
            
            <!--查询-->
            <div class="space_hx">&nbsp;</div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <form action="" method="post">
            <table cellpadding="0" cellspacing="0" class="list_hy">
              <tr >
                
                
                <th scope="col" >姓名</th>
                <th scope="col">总价</th>
                <th scope="col">用户id</th>
                <th scope="col">邮编</th>
                <th scope="col">电话</th>
                <th scope="col">地址</th>
                <th scope="col">日期</th>
                <th scope="col">确认订单</th>
                <th scope="col">状态</th>
                <th>详情</th>
              </tr>
              <c:forEach items="${orderid}" var="d">
              <tr>
                
                <td>${d.name }</td>
                <td >${d.sum }</td>
                <td>${d.uid }</td>
                <td>${d.post }</td>
                <td>${d.phone }</td>
                <td >${d.address }</td>
                <td>${d.date }</td>
                <td>${d.status }</td>
                <td><a href="adminconfirmorder.do?${d.id }">确认</a></td>
                <td><a href="adminshowordermsg.do?id=${d.id }">详情</a></td>
              </tr>
             </c:forEach>
            </table>
            <!--列表-->
            <!--右边底部-->
           
            </form>
            <!--右边底部-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>
