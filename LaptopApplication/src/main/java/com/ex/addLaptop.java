package com.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addLaptop extends HttpServlet{
	Connection connection = null;
	PreparedStatement ps = null;
	public void init(ServletConfig config) {
		try {
			connection=DatabaseConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String companyname=request.getParameter("laptopCompany");
		String features=request.getParameter("laptopFeatures");
		String ram=request.getParameter("Ram");
		String location=request.getParameter("laptopLocation");
		int price=Integer.parseInt(request.getParameter("price"));
//		PrintWriter pw=response.getWriter();
		String sql="insert into addlaptop(companyname,features,ram,location,price) values(?,?,?,?,?)";
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, companyname);
			ps.setString(2, features);
			ps.setString(3, ram);
			ps.setString(4, location);
			ps.setInt(5, price);
			int x= ps.executeUpdate();
			if(x!=0)
				response.sendRedirect("./home.html?msg=Laptop Featues Added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
