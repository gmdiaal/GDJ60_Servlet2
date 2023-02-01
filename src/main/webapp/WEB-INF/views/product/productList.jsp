<%@page import="com.iu.home.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product List Page</h1>
	<%  
		//String name = request.getAttribute("list");
		List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list");
		
		for(ProductDTO dto: ar){ 
			 
	%>
	<h4> <%=  dto.getProduct_num() %> </h4>	
	<h4> <a href="detail.do?productNum=<%=dto.getProduct_num()%>">
		<%=  dto.getProduct_name() %>
	</a> </h4>
		<!-- 세미콜론으로 나누지 못함. -->
		<!-- ./detail.do == detail.do 둘다 절대 경로 아님 /로 시작해야 절대경로 -->
	
	
	
	
	<% } %>
	

	
	
</body>
</html>

<!--  -->