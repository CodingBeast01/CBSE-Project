import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/signup")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // 10MB max file size
public class Signup extends HttpServlet {
  
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Ensure parameters are retrieved correctly
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
           // Part filePart = request.getPart("image"); // Get image file

            // Debugging: Print retrieved values
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);

            // Validate parameters before inserting
            if (name == null || email == null || password == null ) {
                out.println("<h3>Error: Some fields are missing!</h3>");
                return;
            }

           // InputStream imageStream = filePart.getInputStream(); // Convert image to input stream

            // Database connection details
            String jdbcURL = "jdbc:mysql://localhost:3306/codesquadz";
            String dbUser = "root";  
            String dbPassword = "raj";  

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL Query to Insert Data including Image
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
          //  stmt.setBlob(4, imageStream); // Store image as BLOB

            int rowsInserted = stmt.executeUpdate();
            
            if (rowsInserted > 0) {
                out.println("<h3>Sign-Up Successful!</h3>");
                response.setHeader("Refresh", "2;login.html");
            } else {
                out.println("<h3>Sign-Up Failed!</h3>");
            }

            // Close resources
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}

