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
<form action="search.jsp" align="center">
<input type="text" name="search_laptop" placeholder="enter details">
<input type="submit" value="search">
</form>
<table width="500" height="300" align="center">
<tr>
<td>Id</td>
<td>companyname</td>
<td>features</td>
<td>ram</td>
<td>location</td> 
<td>price</td> 
<td>delete</td>
<td>update</td>
</tr>
<%@page import="com.ex.*" %>
<%@page import="java.sql.*" %>
<%
Connection connection = DatabaseConnection.getConnection();
PreparedStatement ps=connection.prepareStatement("select * from addlaptop;");

ResultSet rs=ps.executeQuery();
while(rs.next()){
%>	
<tr>
<td><%=rs.getInt(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4)%></td>
<td><%=rs.getString(5)%></td>
<td><%=rs.getInt(6)%></td>
<td><a href="delete.jsp?id=<%=rs.getInt(1)%>">Delete</a></td>
<td><a href="update.jsp?id=<%=rs.getInt(1)%>">update</a></td>
</tr>
<% }%>

</table>


</body>
</html>