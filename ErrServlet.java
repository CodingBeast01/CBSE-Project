import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrServlet")
public class ErrServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML for the error page
        out.println("<html><head><title>Login Failed</title>");
        out.println("<style>");
		
		
        out.println("body { font-family: Arial, sans-serif; text-align: center; background: #f8d7da; padding: 50px;  background-image: url('images/212566.gif');background-repeat: no-repeat;  background-size: cover; background-position: center;  }");
		
		
		
        out.println(".error-box { width: 400px; margin: auto; padding: 20px; background: white; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        out.println("h2 { color: #721c24; }");
        out.println("p { color: #721c24; font-size: 18px; }");
        out.println("button { background-color: #dc3545; color: white; border: none; padding: 10px 20px; cursor: pointer; font-size: 16px; border-radius: 5px; }");
        out.println("button:hover { background-color: #c82333; }");
		
		
		
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='error-box'>");
        out.println("<h2>Login Failed</h2>");
        out.println("<p>Invalid username or password. Please try again.</p>");
        out.println("<button onclick='window.location.href=\"login.html\"'>Go Back to Login</button>");
        out.println("</div>");

        out.println("</body></html>");
    }
}
