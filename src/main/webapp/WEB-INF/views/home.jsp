<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
	<a href="./product?name=test&detail=explain">Product List</a> 
	<!-- /GDJ60_Servlet2/product 클라이언트 측 입장(보안) controller를 거치면서 찾아가야함. 
	프론트에서는 /product로 쓰면 절대경로가 아님.
	-->
	<a href="./member/memberList.do">Member List</a>
</body>
</html>