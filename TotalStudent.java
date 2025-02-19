import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="TotalStudent",urlPatterns={"/TotalStudent"})

	public class TotalStudent extends HttpServlet
	{
		
		
	/*public void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException,IOException
	{
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<h2>Total number of Students Page</h2>");
	out.close();
	
	}*/
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		System.out.println("do post");
        
        
    }*/
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		response.setHeader("Refresh","4;index.html");

        // HTML structure
        out.println("<html><head>");
        out.println("<title>Student Report</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 20px; padding: 20px; }");
        out.println("h2 { text-align: center; color: #333; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { border: 1px solid black; padding: 10px; text-align: center; }");
        out.println("th { background-color: #4CAF50; color: white; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<h2>Student Report Card</h2>");

        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Change DB details
        String user = "system";
        String password = "mca6";
        String sql = "SELECT * FROM Project";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            out.println("<table>");
            out.println("<tr><th>Student ID</th><th>Name</th><th>Hindi</th><th>English</th><th>Physics</th><th>Chemistry</th><th>Mathematics</th><th>Total Marks</th><th>Percentage</th></tr>");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;
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
				

				
            }

            if (!hasData) {
                out.println("<tr><td colspan='9'>No students found in the database.</td></tr>");
            }

            out.println("</table>");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color: red;'>Error retrieving student data.</p>");
        }
		out.println("<a href='index.html'>Go home</a");
		
		out.println("<br>");
		
			out.println("<a href='GetStudentAverageMarks1'>Download Report</a>");
        out.println("</body></html>");
		
		
		
		
    }
	
	
	
	}
	