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


@WebServlet(name="DeleteStudent",urlPatterns={"/DeleteStudent"})

	public class DeleteStudent extends HttpServlet
	{
		
		
	/*public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException,IOException
	{
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<h2>Delete Student Page</h2>");
	out.close();
	
	}*/
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		  String studentId = request.getParameter("student_id");
        String studentName = request.getParameter("student_name");
		

         String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "system";
        String password = "mca6";
		
        String sql = "DELETE FROM Project WHERE student_id = ? AND student_name = ?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, studentId);
            pstmt.setString(2, studentName);

            int rowsDeleted = pstmt.executeUpdate();
            conn.close();

            if (rowsDeleted > 0) {
               response.sendRedirect("DeleteStudentSuccessPage.html");
			   
            } else {
                response.getWriter().println("Student not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error deleting student.");
        }
		
		
		
		
		
        
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h3>This servlet only handles POST requests. Please submit the form.</h3>");
    }
	
	
	
	
	
	}
	