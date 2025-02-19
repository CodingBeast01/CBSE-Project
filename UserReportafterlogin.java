import javax.servlet.http.*;
import javax.servlet .*;
import java.io .*;
import java.sql .*;
//import com.oreilly.servlet .*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="UserReportafterlogin",urlPatterns={"/UserReportafterlogin"})

public class UserReportafterlogin extends HttpServlet
{
/*
InputStream f=null;
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException

{
	doPost(req,res);
}
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException

{

	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession session = req.getSession(false);
	String username = (String) session.getAttribute("name");
	try
	{
	 Class.forName("com.mysql.jdbc.Driver");
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/codesquadz","root","raj");

	PreparedStatement ps=c.prepareStatement("select image from users where name =? ");
	ps.setString(1,"name");
	ResultSet rs=ps.executeQuery();
	String path=getServletContext().getRealPath("/");
		rs.next();
		f=rs.getBinaryStream("image");
		FileOutputStream f1=new FileOutputStream(path+"\\"+"abc12"+".jpg");
		int i=0;
		while((i=f.read()) !=- 1)
		{

		f1.write(i);
		}

		out.println("<img src='abc12.jpg' width='160' height='170'>");
		}catch(Exception e){
		out.println(e);
		}
		}
		
		*/
		
		
		
		




	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	FileOutputStream f1;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		try {

			HttpSession session = req.getSession();
			//String name = (String) session.getAttribute("name");
			// Validate session
			/*if (name == null) {
				res.sendRedirect("index.html"); // Redirect to login page
				return;
			}*/

			String userName = (String) session.getAttribute("name");
			String profileImage = (String) session.getAttribute("image");
			
			 Class.forName("com.mysql.jdbc.Driver");
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/codesquadz","root","raj");
			
			
			out.println(
					"<html><HEAD><title>User Details</title><link rel='stylesheet' type='text/css' href='css/bootstrap.css' /><link href='css/style.css' rel='stylesheet' /><link href='css/responsive.css' rel='stylesheet' /><script src='js/jquery-3.4.1.min.js'></script><script src='js/bootstrap.js'></script></HEAD><body><div class='hero_area'><header class='header_section'><div class='container'>");

			out.println("<div style=\"display: flex; justify-content: flex-end\">Welcome  " + userName);

			out.println("&nbsp;&nbsp;&nbsp; <a href='login.html'  >Logout</a></div>");

			out.println(
					"<nav class='navbar navbar-expand-lg custom_nav-container '><a class='navbar-brand' href='index.html'><img src='images/logo.png' alt=''><span>CBSE</span></a></nav></div></header>"
					+ "<div class='container'><div class='row'><div class='col-md-6 '><div class='detail_box'>");

			out.println("<div style='display: inline-block; '> <img src='" + profileImage
					+ "' width='200' height='200' class='circular_image'></div>");

			
			PreparedStatement ps = c.prepareStatement(
					"select image from users where name =?");
				ps.setString(1,"name");
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				


				c.close();

				
				// Display the student's percentage

				
				
				//out.println("<form action='/cbse/download'><input type='submit' value='Download Result'></form></div>");
			} else {
				out.println("<h6 style='color:red;'>The results of an exam or assessment are not available online yet, and you need to wait for the official platform to upload them .</h6>");
			}
			 
			
			out.println("</body>");
			out.println("</html>");

			out.println(
					"</BR></BR></BR></div></div></div></div></div><footer class='container-fluid footer_section'><div class='container'><div class='row'><div class='col-lg-7 col-md-9 mx-auto'><p>&copy; 2025 All Rights Reserved By<a href='#'>CBSE</a></p></div></div></div></footer></body></html>");

			out.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
		
		
		
		
		
		
		
		
		
		