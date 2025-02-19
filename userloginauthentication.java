
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
 
 
 @WebServlet(name="userloginauthentication",urlPatterns={"/userloginauthentication"})
 
 public class userloginauthentication extends HttpServlet
 {
	 public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		 doPost(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		
		String name = req.getParameter("name");
		String pass = req.getParameter("password");
			
		try
		
			{
				
				//out.println("Chee sasur");
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/codesquadz","root","raj");
			Statement s = c.createStatement();
			String s1 = "select  * from users where name='"+name+"' and password='"+pass+"' ";
			ResultSet rs = s.executeQuery(s1);
							//out.println(rs.next());
			//out.println("Chee sasur dubara ");
			
			if(rs.next()){
				
				res.sendRedirect("GetStudentAverageMarks.html");
				//res.sendRedirect("UserReportafterlogin");
				//res.sendRedirect("http://google.com");
				//res.sendRedirect("http://localhost:9090/raj/wel");
				//res.sendRedirect("http://13.201.161.138:9090/tom30/wel");
			}
			
				
				
				else{
					//res.sendRedirect("http://localhost:9090/raj/err");
					
					out.println(rs.next());
				res.sendRedirect("ErrServlet");
				}
				}catch(Exception e){out.println(e);}
				out.println("after");
				out.println("</body></html>");
				
				
				}
				
				}