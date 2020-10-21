<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register.do" method="post" enctype="multipart/form-data">
			<input placeholder="username" type="text"  name="username" >
			<input placeholder="name" type="text"  name="name" >
			<input placeholder="eamil" type="text"  name="email" >
			<input placeholder="address" type="text"  name="address" >
			<input placeholder="Mobile" type="text"  name="phone" >
			<input placeholder="Password" type="password"  name="password" >
			 <input type="file" name="imgs">
				
			<input type="submit" value="Submit"></form>
</body>
</html>