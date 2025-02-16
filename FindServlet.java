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

public class FindServlet extends HttpServlet
{
	public void doPost( HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String driverName="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://@localhost:3306/employee";
		String userName = "root";
		String Password = "root";
		String sql = "select * from employee where empNo = ?";
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String empNo = req.getParameter("empNo");
		
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, userName, Password);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, empNo);
			
			
            ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				
				out.println("<br><br><br>");
				out.println("<hr>");
				out.println("<table border='1' align='center' width='80%'>");
					out.println("<thead>");
						out.println("<th>empNo</th><th>empName</th>");
					out.println("</thead>");
					
					out.println("<tr>");
						out.println("<td>"+resultSet.getString(1)+"</td>");
						out.println("<td>"+resultSet.getString(2)+"</td>");
					out.println("</tr>");
				out.println("</table>");
				
			}
			else {
				out.println("<h1> Record Not Found....");
			}
				
		}
		catch(ClassNotFoundException e) {
			out.println(e);
		}
		catch(SQLException e) {
			out.println(e);
		}
		out.println("<br><br><br>");
		out.println("<hr>");
		out.println("<h3>");
		out.println("<a href= Find.html>FIND MORE RECORDS </a><br><br>");
		out.println("<hr>");
		out.println("<a href= index.html> HOME </a>");
		out.println("<hr>");
		out.println("</h3>");
		out.println("<hr>");
	}
}