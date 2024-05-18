import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FactorialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Factorial Calculator</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Factorial Calculator</h1>");
        out.println("<form method=\"post\">");
        out.println("Enter a number: <input type=\"text\" name=\"number\" /><br/><br/>");
        out.println("<input type=\"submit\" value=\"Calculate Factorial\" /><br/><br/>");
        out.println("Factorial: <input type=\"text\" name=\"factorial\" readonly /><br/><br/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numberString = request.getParameter("number");
        int number = Integer.parseInt(numberString);
        int factorial = calculateFactorial(number);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Factorial Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Factorial Result</h1>");
        out.println("<form method=\"post\">");
        out.println("Enter a number: <input type=\"text\" name=\"number\" value=\"" + number + "\" /><br/><br/>");
        out.println("<input type=\"submit\" value=\"Calculate Factorial\" /><br/><br/>");
        out.println("Factorial: <input type=\"text\" name=\"factorial\" value=\"" + factorial + "\" readonly /><br/><br/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    private int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }
}
