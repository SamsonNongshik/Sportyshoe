<%@page import="java.util.List"%>
<%@page import ="com.example.demo.Product.ShoeDao"%>
<%@page import ="com.example.demo.Product.Shoes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>List of Shoes Items</h2>
 <% List <Shoes> ls=(List<Shoes>)request.getAttribute("list"); %>
 <table border="2">
 <tr><th>Product_Id</th><th>Product_Brand</th><th>Product_Desc</th><th>Product_Price</th><th>Product_Category</th><th>Product_Quantity</th><th>Purchase</th></tr>
 <%for(Shoes s:ls){ %>
 <tr><td><%=s.getSid() %></td><td><%=s.getSbrand() %></td><td><%=s.getSdesc() %></td><td><%=s.getSprice() %></td><td><%=s.getScat() %></td><td><%=s.getSquqntity() %></td><td><a href="purchase.jsp"><input type="submit" value="BuyNow"></a></td></tr>
 <%} %>
 </table>
</body>
</html>