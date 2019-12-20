package login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {






    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                String sessionId = session.getId();
                System.out.println("SessionID : " + sessionId);
                String user = (String) session.getAttribute("user");
                out.println("<html>");
                out.println("<body>");
                out.println("<table border='1' width='300'>");
                out.println("<tr>");
                out.println("<td width='300' align='center'>" +
                        user + "Login..!!");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td align='center'>");
                out.println("<a href='#'>Member Info</a>");
                out.println("<a href='Logout'>Logout</a>");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<body>");
                out.println("<form method='post' action='LoginCheck'>");
                out.println("<table border='1' width='300'>");
                out.println("<tr>");
                out.println("<th width='100'>ID</th>");
                out.println("<td width='200'>&nbsp;<input type='text' name='id'></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th width='100'>Password</th>");
                out.println("<td width='200'>&nbsp;<input type='password' name='pwd'></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td align='center' colspan='2'>");
                out.println("<input type='button' value='Register'>");
                out.println("<input type='submit' value='Login'>");
                out.println("</td>");
                out.println("</tr>");
                out.println("</form>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        } finally {
            out.close();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
