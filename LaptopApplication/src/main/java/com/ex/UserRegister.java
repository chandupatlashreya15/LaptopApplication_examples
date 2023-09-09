package com.ex;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserRegister extends HttpServlet {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		int phone=Integer.parseInt(request.getParameter("phone"));
		String address=request.getParameter("address");
		PrintWriter pw=response.getWriter();
		String sql="insert into user(username,password,email,phone,address) values(?,?,?,?,?)";
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setInt(4, phone);
			ps.setString(5, address);
			int x= ps.executeUpdate();
			if(x!=0)
				response.sendRedirect("./login.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
		
	
}
