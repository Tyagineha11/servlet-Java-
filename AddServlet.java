package com.neha.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String driverName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://@localhost:3306/employee";
		String userName="root";
		String Password="root";
		
		
		String sql="insert into employee values(?,?,?)";
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		Integer empNo=Integer.parseInt(req.getParameter("empNo"));
		String empName= req.getParameter("empName");
		Double empSal = Double.parseDouble(req.getParameter("empSal"));
		
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection( url, userName, Password);			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,empNo);
			preparedStatement.setString(2,empName);
			preparedStatement.setDouble(3,empSal);
			
			Integer count = preparedStatement.executeUpdate();
			out.println("<h1>" + count + "Record addred in a Table</h1>");
		}
		catch(ClassNotFoundException e)
		{
		out.println(e);
	}
		catch(SQLException e)
		{
			out.println(e);
		}
		out.println("<hr>");
		out.println("<h3>");
		out.println("<a href= add.html>ADD MORE RECORDS </a><br><br>");
		out.println("<hr>");
		out.println("<a href= index.html> HOME </a>");
		out.println("<hr>");
		out.println("</h3>");
		out.println("<hr>");
}
}

	
