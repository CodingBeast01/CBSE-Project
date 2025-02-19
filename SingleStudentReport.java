import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SingleStudentReport",urlPatterns={"/SingleStudentReport"})

	public class SingleStudentReport extends HttpServlet
	{
		
		
	
	
	
	
	
		public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{

			/*try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
			//Statement stmt=c.createStatement();
			String studentId = req.getParameter("student_id");
			
			 stmt = c.createStatement();
            String query = "SELECT * FROM project WHERE student_id = '" + studentId + "'";
            rs = stmt.executeQuery(query);

            ResultSetMetaData rd = rs.getMetaData();


			//ResultSet rs=stmt.executeQuery("select * from project WHERE student_id = ?");

			ResultSetMetaData rd=rs.getMetaData();
			res.setContentType("application/vnd.ms-excel");
			res.setHeader("Content-Disposition", "attachment; filename=Total Student.xls");
			PrintWriter out=res.getWriter();
			int count=rd.getColumnCount();


	for(int i=1;i <= count;i++)
	{
		out.print(rd.getColumnName(i)+"\t");


	}
		out.println("");
		int x=2;
		while(rs.next())
		{

		out.print(rs.getString(1)+"\t");
		out.print(rs.getString(2)+"\t");
		out.print(rs.getString(3)+"\t");
		out.print(rs.getString(4)+"\t");
		out.print(rs.getString(5)+"\t");
		out.print(rs.getString(6)+"\t");
		out.print(rs.getString(7)+"\t");
		out.println("");

		}
		}catch(Exception e){e.printStackTrace();}
		*/
		
		
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	