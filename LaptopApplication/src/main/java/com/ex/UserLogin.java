package com.ex;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class UserLogin extends HttpServlet {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		String sql="select * from user where email=? and password=?";
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet x= ps.executeQuery();
			HttpSession hs = request.getSession();
		
			if(x.next()) {
				hs.setAttribute("email", email);
				hs.setAttribute("id", x.getInt(1));
				response.sendRedirect("./home.html?msg=Logged Into the Laptop application!");
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
		
	
}
