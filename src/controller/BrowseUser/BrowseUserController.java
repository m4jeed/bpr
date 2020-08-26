package controller.BrowseUser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businessFunction.user.DeleteUser;
import businessFunction.user.GetUser;
import businessFunction.user.GetUserList;
import businessFunction.user.SaveUser;
import entities.User;
import tools.Dto;

public class BrowseUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Dto> browseList = new HashMap<String, Dto>();
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		 
        try {
        	switch (action) {
        	 case "/searchUser":
        		 searchUserData(request, response, action);
                 break;
        	 case "/newUser":
        		 showUserForm(request, response);
                 break;
        	 case "/insertUser":
                 insertUserData(request, response);
                 break;
        	 case "/editUser":
                 editUserData(request, response);
                 break;
        	 case "/updateUser":
                 updateUserData(request, response);
                 break;
        	 case "/deleteUser":
                 deleteUserData(request, response);
                 break;
        	 case"/user":
                 getList(request, response);
                 break;
                 
        	}
 
        	//resList(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void searchUserData(HttpServletRequest request, HttpServletResponse response, String key)
            throws SQLException, IOException, ServletException{
		 
		 List<User> result = search(request);
		
		 request.setAttribute("resList", result);
	     RequestDispatcher dispatcher = request.getRequestDispatcher("user/vUserList.jsp");
	     dispatcher.forward(request, response);
	}
	
	private List<User> search(HttpServletRequest request) {
		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			String username = request.getParameter("username");
			String grp = request.getParameter("grp");
			 
			Dto par = new Dto();
			par.putString("username", username);
			par.putString("grp", grp);
			List<User> result = new ArrayList<User>();
			
			List<Dto> resultList = GetUserList.execute(par);
		    User benda = new User();
			result = benda.getEntityList(resultList);
			
			for(Dto item : resultList){
				browseList.put(item.getString("id"), item);
			 }
			return result;
	}
	
	private void getList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		List<User> result = search(request);
		
	    request.setAttribute("resList", result);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("user/vUserList.jsp");
	    dispatcher.forward(request, response);
	}
	
	private void showUserForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/vUserForm.jsp");
        dispatcher.forward(request, response);
	}
	
	private void insertUserData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
		 Class.forName("tools.Dto");
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 String username 	= request.getParameter("username");
		 String password 	= request.getParameter("pass");
		 String mac 		= request.getParameter("mac");
		 String grp 		= request.getParameter("grp");
		 String status 		= request.getParameter("status");
	    	
		 Dto param = new Dto();
		 param.putString("username", username);
		 param.putString("password", password);
		 param.putString("mac", mac);
		 param.putString("grp", grp);
		 param.putString("status", status);
		 try {
			 SaveUser.execute(param);
			} catch (Exception e) {
				//e.printStackTrace();
			}
	        response.sendRedirect("/bpr/user");
    }
	
	private void editUserData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
		String id = request.getParameter("id");
		
		Dto selected = browseList.get(id);
		User set = new User();
		set = set.getEntity(selected);
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("user/vUserForm.jsp");
	 	request.setAttribute("getEdit", set);
	    dispatcher.forward(request, response);
	}
	
	private void updateUserData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
	 
        String id 		= request.getParameter("id");
        String username = request.getParameter("username");
        String mac 		= request.getParameter("mac");
        String grp 		= request.getParameter("grp");
        String status 	= request.getParameter("status");
        
        Dto param = browseList.get(id);
        param.putString("username", username);
        param.putString("mac", mac);
        param.putString("grp", grp);
        param.putString("status", status);
    
        try {
			SaveUser.execute(param);
		} catch (Exception e) {
			
		}
        
        response.sendRedirect("/bpr/user");
	 
	}
	
	private void deleteUserData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
		 String id = request.getParameter("id");
		 Dto par = new Dto();
		 par.putString("id", id);
		 Dto userDto = GetUser.execute(par);
		 DeleteUser.execute(userDto);
		 response.sendRedirect("/bpr/user");
	
	}
	

}
