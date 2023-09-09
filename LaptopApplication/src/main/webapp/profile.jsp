<!DOCTYPE html>
<html>
<head>
<title>
Servlet Page
</title>
</head>
<body>
<h1 align = "center">Welcome to Home Page</h1>
<center>
<a href="profile.jsp">Profiles</a> <br>
<a href="add_laptop.html">Add Laptop</a>
<a href="view_laptops.jsp">view laptops</a><br>
<a href="index.html">Logout</a>
</center>
<br>
<table width="500" height="300" align="center">
<tr>
<td>Id</td>
<td>Username</td>
<td>Email</td>
<td>Phone</td>
<td>Address</td> 
</tr>
<%@page import="com.ex.*" %>
<%@page import="java.sql.*" %>
<%
Connection connection = DatabaseConnection.getConnection();
String email=(String)session.getAttribute("email");
PreparedStatement ps=connection.prepareStatement("select * from user where email=?;");
ps.setString(1,email);
ResultSet rs=ps.executeQuery();
while(rs.next()){
%>	
<tr>
<td><%=rs.getInt(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(4)%></td>
<td><%=rs.getString(5)%></td>
<td><%=rs.getString(6)%></td>
</tr>
<% }%>

</table>


</body>
</html>