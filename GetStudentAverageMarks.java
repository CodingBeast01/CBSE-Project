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

@WebServlet(name="GetStudentAverageMarks",urlPatterns={"/GetStudentAverageMarks"})

	public class GetStudentAverageMarks extends HttpServlet
	{
		
		
	/*public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException,IOException
	{
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<h2> Student Report Page</h2>");
	out.close();
	
	}*/ 
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		System.out.println("do post");
        
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		
		 response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		//response.setHeader("Refresh","4;index.html");

        String studentId = request.getParameter("student_id");
        //String studentName = request.getParameter("student_name");

        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "system";
        String password = "mca6";
        String sql = "SELECT * FROM Project WHERE student_id = ? ";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
           // pstmt.setString(2, studentName);
            ResultSet rs = pstmt.executeQuery();

            out.println("<html><head><title>Student Report</title></head><body>");
            out.println("<h2>Student Report</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Student ID</th><th>Name</th><th>Hindi</th><th>English</th><th>Physics</th><th>Chemistry</th><th>Mathematics</th></tr>");

            if (rs.next()) {
                int hindi = Integer.parseInt(rs.getString("hindi"));
                int english = Integer.parseInt(rs.getString("english"));
                int physics = Integer.parseInt(rs.getString("physics"));
                int chemistry = Integer.parseInt(rs.getString("chemistry"));
                int mathematics = Integer.parseInt(rs.getString("mathematics"));

                int totalMarks = hindi + english + physics + chemistry + mathematics;
                double percentage = (totalMarks / 500.0) * 100;

                out.println("<tr>");
                out.println("<td>" + rs.getString("student_id") + "</td>");
                out.println("<td>" + rs.getString("student_name") + "</td>");
                out.println("<td>" + hindi + "</td>");
                out.println("<td>" + english + "</td>");
                out.println("<td>" + physics + "</td>");
                out.println("<td>" + chemistry + "</td>");
                out.println("<td>" + mathematics + "</td>");
                out.println("<td>" + totalMarks + "</td>");
                out.println("<td>" + String.format("%.2f", percentage) + "%</td>");
                out.println("</tr>");
            } else {
                out.println("<tr><td colspan='7'>No student found</td></tr>");
            }
            out.println("</table>");
			out.println("<a href='GetStudentAverageMarks1'>Download Report</a>");
			
            out.println("</body></html>");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error retrieving student data</p>");
        }
		
		
		
		
		
		//response.sendRedirect("GetStudentAverageMarks.html");
       // response.getWriter().println("<h3>This servlet only handles POST requests. Please submit the form.</h3>");
    }
	
	
	
	}
	