package edu.jspiders.dynamic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveServlet extends HttpServlet
{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();
	  
	  String id=req.getParameter("id");
	  
	  int id1=Integer.parseInt(id);
	  out.println("<h2>Record is removed successfully!!!</h2>");
	  
	  try {
		remove(id1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
}
  
  public void remove(int id1) throws SQLException
  {
	  //step2
	  Driver d=new com.mysql.jdbc.Driver();
	  DriverManager.registerDriver(d);
	  
	  //step 3
	  String db="jdbc:mysql://localhost:3306/student_info2?user=root&password=root";
	  Connection con=DriverManager.getConnection(db);
	  
	  //step4
	  String q="DELETE from student WHERE id=?";
	  PreparedStatement stmt=con.prepareStatement(q);
	  
	  stmt.setInt(1, id1);
	  
	  stmt.executeUpdate();
			
  }
}
