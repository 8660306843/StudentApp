package edu.jspiders.dynamic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		  resp.setContentType("text/html");
		  PrintWriter out=resp.getWriter();
		  
		  String id=req.getParameter("id");
		  String name=req.getParameter("name");
		  String marks=req.getParameter("marks");
		  
		 out.println("<h2>Record is inserted Successfully!!!</h2>");
		 
		  
		  int id1=Integer.parseInt(id);
		  double marks1=Double.parseDouble(marks);
		  
		  try {
			insert(id1,marks1,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 
	}
	
	public void insert(int id1,double marks1,String name) throws SQLException
	{ 
		//step 2
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		//step3
		String db="jdbc:mysql://localhost:3306/student_info2?user=root&password=root";
		Connection con=DriverManager.getConnection(db);
		
		//step4
        String q="INSERT into student values(?,?,?)"; //dynamic query
		
		
		PreparedStatement stat=con.prepareStatement(q);
		
		stat.setInt(1, id1);
		stat.setString(2, name);
		stat.setDouble(3, marks1);
		
		stat.executeUpdate();
		
		
		
		
	
		
		
	}

}
