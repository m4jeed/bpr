package controller.BrowseUserMenu;

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

import businessFunction.userMenu.DeleteUserMenu;
import businessFunction.userMenu.GetUserMenu;
import businessFunction.userMenu.GetUserMenuList;
import businessFunction.userMenu.SaveUserMenu;
import entities.UserMenu;
import tools.Dto;

public class BrowseUserMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Dto> browseList = new HashMap<String, Dto>();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action){
			 case "/searchUserMenu":
				 searchUserMenuData(request, response, action);
             break;
			 case "/newUserMenu":
				 showUsermenuForm(request, response);
             break;
			 case "/insertUserMenu":
				 insertUserMenuData(request, response);
             break; 
			 case "/editUserMenu":
				 editUserMenuData(request, response);
             break;
			 case "/updateUserMenu":
				 updateUserMenuData(request, response);
             break;
			 case "/deleteUserMenu":
                 deleteUserMenuData(request, response);
                 break;
			 case"/usermenu":
				 getList(request, response);
             break;
			}
			
		}catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void searchUserMenuData(HttpServletRequest request, HttpServletResponse response, String key)
            throws SQLException, IOException, ServletException{
		 
		 List<UserMenu> result = search(request);
		
		 request.setAttribute("resList", result);
	     RequestDispatcher dispatcher = request.getRequestDispatcher("usermenu/vUserMenuList.jsp");
	     dispatcher.forward(request, response);
	}
	
	private List<UserMenu> search(HttpServletRequest request) {
		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			String userId = request.getParameter("userId");
			String menuName = request.getParameter("menuName");
			 
			Dto par = new Dto();
			par.putString("userId", userId);
			par.putString("menuName", menuName);
			List<UserMenu> result = new ArrayList<UserMenu>();
			
			List<Dto> resultList = GetUserMenuList.execute(par);
			UserMenu varMenu = new UserMenu();
			result = varMenu.getEntityList(resultList);
			
			for(Dto item : resultList){
				browseList.put(item.getString("id"), item);
			 }
			return result;
	}
	
	private void getList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		List<UserMenu> result = search(request);
		request.setAttribute("resList", result);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("usermenu/vUserMenuList.jsp");
	    dispatcher.forward(request, response);
	}
	
	private void showUsermenuForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 
        RequestDispatcher dispatcher = request.getRequestDispatcher("usermenu/vUserMenuForm.jsp");
        dispatcher.forward(request, response);
	}
	
	private void insertUserMenuData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
		 Class.forName("tools.Dto");
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 String userId 		= request.getParameter("userId");
		 String menuName	= request.getParameter("menuName");
		 String subMenu 	= request.getParameter("subMenu");
	    	
		 Dto param = new Dto();
		 param.putString("userId", userId);
		 param.putString("menuName", menuName);
		 param.putString("subMenu", subMenu);
		 try {
			 SaveUserMenu.execute(param);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        response.sendRedirect("/bpr/usermenu");
    }
	
	private void editUserMenuData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
		String id = request.getParameter("id");
		
		Dto selected = browseList.get(id);
		UserMenu set = new UserMenu();
		set = set.getEntity(selected);
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("usermenu/vUserMenuForm.jsp");
	 	request.setAttribute("getEdit", set);
	    dispatcher.forward(request, response);
	}
	
	private void updateUserMenuData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
	 
        String id 		= request.getParameter("id");
        String userId 	= request.getParameter("userId");
        String menuName = request.getParameter("menuName");
        String subMenu 	= request.getParameter("subMenu");
        
        Dto param = browseList.get(id);
        param.putString("userId", userId);
        param.putString("menuName", menuName);
        param.putString("subMenu", subMenu);
    
        try {
			SaveUserMenu.execute(param);
		} catch (Exception e) {
			
		}
        
        response.sendRedirect("/bpr/usermenu");
	 
	}
	
	private void deleteUserMenuData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
		 String id = request.getParameter("id");
		 Dto par = new Dto();
		 par.putString("id", id);
		 Dto usersmenuDto = GetUserMenu.execute(par);
		 DeleteUserMenu.execute(usersmenuDto);
		 response.sendRedirect("/bpr/usermenu");
	
	}
	
	
	
	

}
