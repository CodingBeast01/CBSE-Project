import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
 
 
 @WebServlet(name="Login",urlPatterns={"/Login"})
 public class Login extends HttpServlet
 {
 
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
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
			Statement s = c.createStatement();
			String s1 = "select  * from emp101 where name='"+name+"' and password='"+pass+"' ";
			ResultSet rs = s.executeQuery(s1);
							//out.println(rs.next());
			//out.println("Chee sasur dubara ");
			
			
			
			
					HttpSession session = req.getSession();
					
					

					session.setAttribute("username", name);
					//session.setAttribute("usertype", userType);


			
			if(rs.next()){
				
				res.sendRedirect("index.html");
				//res.sendRedirect("wel");
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