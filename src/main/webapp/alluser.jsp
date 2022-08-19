<%@page import="com.example.demo.User.User"%>
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
<h1>User List</h1>
<%List<User> list=(List<User>)request.getAttribute("ls");%>

<table border="2">
<tr><th>User_Id</th><th>User_Name</th><th>User_Email</th><th>User_Password</th></tr>
<%for(User u:list) {%>
<tr><td><%=u.getUid() %></td><td><%=u.getUname() %></td><td><%=u.getUemail() %></td><td><%=u.getUpassword() %></td></tr>
<%} %>
</table>
</body>
</html>