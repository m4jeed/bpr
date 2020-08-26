package controller.BrowseLogin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessFunction.absen.GetAbsenList;
import businessFunction.user.GetUser;
import businessFunction.userMenu.GetUserMenuList;
import entities.Absen;
import tools.Dto;

@WebServlet("/log")
public class BrowseAuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String destPage = "login/vLogin.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		
		//buat panggil data username
		Dto param = new Dto();
		param.putString("username", username);
		param.putString("id", id);
		Dto user = GetUser.execute(param);
		
		//buat nampilin data absen
		Absen abs = new Absen();
		Dto parAbsen = new Dto();
		List<Dto> resList = GetAbsenList.execute(parAbsen);
		List<Absen> result = abs.getEntityList(resList);
		
		//buat panggil data menu
		Dto parMenu = new Dto();
		parMenu.putString("userId", user.getString("id"));
		List<Dto> menuList = GetUserMenuList.execute(parMenu);
		
		HttpSession session = request.getSession(); 
		session.setMaxInactiveInterval( 900 );
		for(Dto item : menuList){
			session.setAttribute(item.getString("subMenu"), "1");
			
			if(session.getAttribute(item.getString("menuName")) == null){
				session.setAttribute(item.getString("menuName"), "1");
			}
		}
		
		if(user.getString("grp").equals("admin") && user.getString("password").equals(password) ){
			System.out.println("admin");
//			HttpSession session = request.getSession(); 
			session.setAttribute("role", "admin");
			RequestDispatcher rd =  request.getRequestDispatcher("welcome/vWelcome.jsp");
			request.setAttribute("resList", result);
			rd.include(request, response);
		}else if(user.getString("grp").equals("member") && user.getString("password").equals(password)){
	        session.setAttribute("role", "member");
			RequestDispatcher rd =  request.getRequestDispatcher("welcome/vWelcome.jsp");
			request.setAttribute("resList", result);
			rd.include(request, response);
			
		}else if(user.getString("grp").equals("karyawan") && user.getString("password").equals(password)){
	        session.setAttribute("role", "karyawan");
			RequestDispatcher rd =  request.getRequestDispatcher("welcome/vWelcome.jsp");
			request.setAttribute("resList", result);
			rd.include(request, response);
			
		}else{
			
			String message = ("<html><body>Sorry, username atau password salah</body></html>");
			request.setAttribute("pesan", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
		}
		

		
		
		
	}

}
