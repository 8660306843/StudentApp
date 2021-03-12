package edu.jspiders.dynamic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		  PrintWriter out=resp.getWriter();
		  
		  String id=req.getParameter("id");
		  String marks=req.getParameter("marks");
		  
		  out.println("<h2>Record is updated Successfully!!!</h2>");
		  
		  int id1=Integer.parseInt(id);
		  double marks1=Double.parseDouble(marks);
		  
		  try {
			update(id1,marks1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 
		
	
	}
	
	public void update(int id1,double marks1) throws SQLException
	{
		//step2
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		//step3
		String db="jdbc:mysql://localhost:3306/student_info2?user=root&password=root";
		Connection con=DriverManager.getConnection(db);
		
		//step4
		String q="UPDATE student "+
				"SET marks="+marks1+
				"WHERE id =?";
		
		PreparedStatement stmt=con.prepareStatement(q);
		stmt.setInt(1, id1);
		
		
		stmt.executeUpdate();
				
				

		
	}

}
