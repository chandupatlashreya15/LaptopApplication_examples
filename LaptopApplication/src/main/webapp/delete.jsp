<%@page import="com.ex.*" %>
<%@page import="java.sql.*" %>
<%
Connection connection = DatabaseConnection.getConnection();
int id=Integer.parseInt(request.getParameter("id"));
PreparedStatement ps=connection.prepareStatement("delete from addlaptop where id=?");
ps.setInt(1,id);
int x=ps.executeUpdate();
if(x!=0)
	response.sendRedirect("./view_laptops.jsp?msg=book deleted");
%>