<%@page import="com.iu.home.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Page Product Detail</h1>
	
	<%ProductDTO dto = (ProductDTO)request.getAttribute("dto"); %>
	<h3> <%= dto.getProduct_name() %> </h3>
	<h3> <%= dto.getProduct_detail() %> </h3>
	<h3> <%= dto.getProduct_score() %> </h3>
	
</body>
</html>