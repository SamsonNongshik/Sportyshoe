<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String s=(String)session.getAttribute("auser"); %>
Welcome <%=s %>!<br><br>

<a href="addproduct.jsp"><input type="submit" value="Add Product"></a><br><br>
<form action="getall">
<input type="submit" value="Product Lists"></form><br>
<a href="editproduct.jsp"><input type="submit" value="Edit Product"></a><br><br>
<a href="deleteproduct.jsp"><input type="submit" value="Delete Product"></a><br><br>
<form action="userlist">
<input type="submit" value="UserList"></form><br>
</body>
</html>