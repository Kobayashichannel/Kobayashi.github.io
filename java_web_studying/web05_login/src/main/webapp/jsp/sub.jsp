<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>get提交方式</h1>
<form action="${ pageContext.request.contextPath }/ServletDemo1" method="get">
	姓名:<input type="text" name="name"/><br>
	<input type="submit" value="提交">
</form>
<h1>post提交方式</h1>
<form action="${ pageContext.request.contextPath }/ServletDemo1" method="post">
	姓名:<input type="text" name="name"/><br>
	<input type="submit" value="提交">
</form>
</body>
</html>