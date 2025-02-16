package com.neha.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException
	{
		String driverName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://@localhost:3306/employee";
		String userName="root";
		String Password="root";
		res.setContentType("text/html");
		
		PrintWriter out=res.getWriter();
		String sql="select * from employee";
		
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, userName, Password);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			out.println("<hr>");
			out.println("<br><br><br>");
			out.println("<table border='1' align='center' width='80%'>");
			out.println("<thead>");
			out.println("<th>empNo</th><th>empName</th><th>empSal</th>");
			out.println("</thead>");
			while(resultSet.next())
			{
				out.println("<tr>");
				out.println("<td>" +resultSet.getInt(1)+"</td>");
				out.println("<td>" +resultSet.getString(2)+"</td>");
				out.println("<td>" +resultSet.getDouble(3)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
		catch(ClassNotFoundException e)
		{
		out.println(e);
	}
		catch(SQLException e)
		{
			out.println(e);
		}
		out.println("<br><br><br>");
		out.println("<hr>");
		out.println("<h3>");
		out.println("<a href= index.html> HOME </a>");
		out.println("</h3>");
		out.println("<hr>");
	
}

	private String resultSetgetDouble(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private String resultSetgetInt(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private String resultSetgetString(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private String ResultSetgetInt(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
