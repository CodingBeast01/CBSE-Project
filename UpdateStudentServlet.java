import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML Form for Updating Student Marks
        out.println("<html><head><title>Update Student Marks</title>");
        out.println("<style>");
		
		
        out.println("body { font-family: Arial, sans-serif; margin: 20px; background: #f8d7da; padding: 50px;  background-image: url('images/updatestudent.png');background-repeat: no-repeat;  background-size: cover; background-position: center; }");
		
		
		
		
        out.println("form { width: 400px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background: #f9f9f9; }");
        out.println("input, button { width: 100%; padding: 10px; margin: 5px 0; }");
        out.println("button { background-color: #28a745; color: white; border: none; cursor: pointer; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<h2 style='text-align:center;'>Update Student Marks</h2>");
        out.println("<form method='post' action='UpdateStudentServlet'>");
        out.println("<label>Student ID:</label>");
        out.println("<input type='text' name='studentId' required>");
        out.println("<label>Hindi:</label>");
        out.println("<input type='text' name='hindi' required>");
        out.println("<label>English:</label>");
        out.println("<input type='text' name='english' required>");
        out.println("<label>Physics:</label>");
        out.println("<input type='text' name='physics' required>");
        out.println("<label>Chemistry:</label>");
        out.println("<input type='text' name='chemistry' required>");
        out.println("<label>Mathematics:</label>");
        out.println("<input type='text' name='mathematics' required>");
        out.println("<button type='submit'>Update Student</button>");
        out.println("</form>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get input values from form
        String studentId = request.getParameter("studentId");
        String hindi = request.getParameter("hindi");
        String english = request.getParameter("english");
        String physics = request.getParameter("physics");
        String chemistry = request.getParameter("chemistry");
        String mathematics = request.getParameter("mathematics");

        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Change DB details
        String user = "system";
        String password = "mca6";
        String sql = "UPDATE Project SET hindi=?, english=?, physics=?, chemistry=?, mathematics=? WHERE student_id=?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, hindi);
            pstmt.setString(2, english);
            pstmt.setString(3, physics);
            pstmt.setString(4, chemistry);
            pstmt.setString(5, mathematics);
            pstmt.setString(6, studentId);

            int rowsUpdated = pstmt.executeUpdate();

            out.println("<html><body>");
			
            if (rowsUpdated > 0) {
				
                response.sendRedirect("updatestudentsuccess.html");
				
            } else {
				
                out.println("<h3 style='color:red;'>Student not found!</h3>");
            }
			
            out.println("<a href='index.html'>Go Back to HomePage</a>");
            out.println("</body></html>");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error updating student details.</p>");
        }
    }
}
