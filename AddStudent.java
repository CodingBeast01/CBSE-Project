import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet(name="AddStudent",urlPatterns={"/AddStudent"})

	public class AddStudent extends HttpServlet
	{
		
	/*public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException,IOException
	{
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<h2>Please Enter Student Information</h2>");
	out.close();
	
	}*/
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        
		String studentId = request.getParameter("student_id");
        String studentName = request.getParameter("student_name");
        String hindi = request.getParameter("hindi");
        String english = request.getParameter("english");
        String physics = request.getParameter("physics");
        String chemistry = request.getParameter("chemistry");
        String mathematics = request.getParameter("mathematics");
        
		
		
		 String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "system";
        String password = "mca6";
        String sql = "INSERT INTO Project (student_id, student_name, hindi, english, physics, chemistry, mathematics) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, studentId);
            pstmt.setString(2, studentName);
            pstmt.setString(3, hindi);
            pstmt.setString(4, english);
            pstmt.setString(5, physics);
            pstmt.setString(6, chemistry);
            pstmt.setString(7, mathematics);

            int rowsInserted = pstmt.executeUpdate();
            conn.close();
        
        
        response.sendRedirect("success.html");
		
		
		 } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error inserting student data.");
        }
		
		
		
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h3>This servlet only handles POST requests. Please submit the form.</h3>");
    }
	
	}
	