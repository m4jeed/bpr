package controller.BrowseLogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class BrowseLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			
			session.invalidate(); //removes all session attributes bound to the session
            request.setAttribute("pesan", "Logout Berhasil");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login/vLogin.jsp");
            requestDispatcher.forward(request, response);
            //System.out.println("Logged out");
		}
	}

}
