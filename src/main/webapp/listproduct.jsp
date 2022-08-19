<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.example.demo.Product.Shoes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header> List Of Products </header><br><br><br>
<% List<Shoes> list=(List<Shoes>)request.getAttribute("list");
%>

<table border="3">
<tr><th>Product_Id</th><th>Product_Brand</th><th>Product_Desc</th><th>Product_Price</th><th>Product_Category</th><th>Product_Quantity</th></tr>

<%for(Shoes s:list) {%>
<tr><td><%=s.getSid() %></td><td><%=s.getSbrand() %></td><td><%=s.getSdesc() %></td><td><%=s.getSprice() %></td><td><%=s.getScat() %></td><td><%=s.getSquqntity() %></td></tr>
<%} %>
</table>
</body>
</html>