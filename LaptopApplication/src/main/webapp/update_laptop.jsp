<%@page import="com.ex.*" %>
<%@page import="java.sql.*" %>
<%
Connection connection = DatabaseConnection.getConnection(); 
int id= Integer.parseInt(request.getParameter("id"));
String companyname=request.getParameter("laptopCompany");
String features=request.getParameter("laptopFeatures");
String ram=request.getParameter("Ram");
String location=request.getParameter("laptopLocation");
int price=Integer.parseInt(request.getParameter("price"));
PreparedStatement ps=connection.prepareStatement("update addlaptop set companyname=?,features=?,ram=?,location=?,price=?,id=?");
ps.setString(1, companyname);
ps.setString(2, features);
ps.setString(3, ram);
ps.setString(4, location);
ps.setInt(5, price);
ps.setInt(6,id);
int x=ps.executeUpdate();
if(x!=0){
	response.sendRedirect("./view_laptops.jsp?msg=Laptop Updated");
}
%>