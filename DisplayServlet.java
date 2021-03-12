package edu.jspiders.dynamic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<h1>Student id \t\t Student name \t\t Student marks</h1>");
		
		try {
			display(out);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  
		  
	}
	
	public void display(PrintWriter out) throws SQLException
	  {
		  //step2
		  Driver d=new com.mysql.jdbc.Driver();
		  DriverManager.registerDriver(d);
		  
		  //step3
		  String db="jdbc:mysql://localhost:3306/student_info2?user=root&password=root";
		  Connection con=DriverManager.getConnection(db);
		  
		  //step4
		  String q="SELECT id,name,marks from student";
		  Statement stmt=con.createStatement();
		  
		  
		  
		  ResultSet r=stmt.executeQuery(q);
		  
		  while(r.next())
		  {
		  out.print("<h2>"+r.getInt(1)+"                      "+r.getString(2)+"             "+r.getDouble(3)+"</h2>");
			 


}
}
}
