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
<a href="profile.jsp">About Page</a> <br>
<a href="add_laptop.html">Add Laptop</a>
<a href="view_laptops.jsp">view laptops</a><br>
<a href="index.html">Logout</a>
</center>
<%@page import="com.ex.*" %>
<%@page import="java.sql.*" %>
<%
Connection connection = DatabaseConnection.getConnection();
int id= Integer.parseInt(request.getParameter("id")); 
PreparedStatement ps=connection.prepareStatement("select * from addlaptop;");

ResultSet rs=ps.executeQuery();
if(rs.next()){
	
}
%>	
<form action="./update_laptop.jsp" method="post" align="center">
<input type="hidden" name="id" value="value="<%=rs.getInt(1)%>">
<input type="text" name="laptopCompany" value="<%=rs.getString(2)%>">
<input type="text" name="laptopFeatures" value="<%=rs.getString(3)%>">
<input type="text" name="Ram" value="<%=rs.getString(4)%>">
<input type="text" name="laptopLocation" value="<%=rs.getString(5)%>">
<input type="text" name="price" value="<%=rs.getInt(6)%>">
<input type="submit">
</form>


</body>
</html>