package edu.jspiders.dynamic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet
{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();
	  
	  String id=req.getParameter("id");
	  
	  int id1=Integer.parseInt(id);
	 try {
		search(id1,out);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
}
  
  public void search(int id1,PrintWriter out) throws SQLException
  {
	  //step2
	  Driver d=new com.mysql.jdbc.Driver();
	  DriverManager.registerDriver(d);
	  
	  //step3
	  String db="jdbc:mysql://localhost:3306/student_info2?user=root&password=root";
	  Connection con=DriverManager.getConnection(db);
	  
	  //step4
	  String q="SELECT id,name,marks from student WHERE id=?";
	  PreparedStatement stmt=con.prepareStatement(q);
	  
	  stmt.setInt(1, id1);
	  
	  ResultSet r=stmt.executeQuery();
	  
	  while(r.next())
	  {
	  /*out.println("<h1>Student id \t\t Student name \t\t Student marks</h1>");
	  out.println("<hr>");
	  out.print("<h2>"+r.getInt(1)+"            "+r.getString(2)+"             "+r.getDouble(3)+"</h2>");*/
		  
		  String html="<doctype Html>"
				   + "<html>"
				   + "<head>"
				   + "<title>"
				   + "Students database"
				   + "</title>"
				   + "</head>"
				   + "<body>"
				   +"<table border="+"1"+">"
				   + "<caption>Students Database</caption>"
				   + "<tr>"
				   + "<th>Student id</th>"
				   + "<th>Student name</th>"
				   + "<th>Student marks</th>"
				   + "</tr>"
				   + "<tr>"
				   + "<td>"+r.getInt(1)+"</td>"
				   + "<td>"+r.getString(2)+"</td>"
				   + "<td>"+r.getDouble(3)+"</td>"
				   + "</body>"
				   + "</html>";
		   
		          out.print(html);
		   
	  
	  }
	  
	  

	  
	  
	  
  }
}
