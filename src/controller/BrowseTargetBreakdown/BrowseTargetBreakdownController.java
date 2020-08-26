package controller.BrowseTargetBreakdown;

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

import businessFunction.targetBreakdown.DeleteTargetBreakdown;
import businessFunction.targetBreakdown.GetTargetBreakdown;
import businessFunction.targetBreakdown.GetTargetBreakdownList;
import businessFunction.targetBreakdown.SaveTargetBreakdown;
import entities.TargetBreakdown;
import tools.Dto;

public class BrowseTargetBreakdownController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Dto> browseList = new HashMap<String, Dto>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
		 doGet(request, response);
    }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
	        String action = request.getServletPath();
	 
	        try {
	        	switch (action) {
	        	case "/newDataTargetbreakdown":
	        		 showTargetForm(request, response);
	                 break;
	        	 case "/insertDataTargetbreakdown":
	                 insertTargetData(request, response);
	                 break;
	        	 case "/editDataTargetbreakdown":
	                 editTargetData(request, response);
	                 break;
	        	 case "/updateDataTargetbreakdown":
	                 updateTargetData(request, response);
	                 break;
	        	 case "/deleteDataTargetbreakdown":
	                 deleteTargetData(request, response);
	                 break;
	        	 case "/searchDataTargetbreakdown":
	        		 searchTargetData(request, response, action);
	                 break;
	        	 case"/targetbreakdown":
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
	  
	private void getList(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException{
		List<TargetBreakdown> result = search(request);
		
        request.setAttribute("resList", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("targetbreakdown/vTargetBreakdownList.jsp");
        dispatcher.forward(request, response);
	}
	
	private void showTargetForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
	        RequestDispatcher dispatcher = request.getRequestDispatcher("targetbreakdown/vTargetBreakdownForm.jsp");
	        dispatcher.forward(request, response);
	}
	 
	private void insertTargetData(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ClassNotFoundException {
		 Class.forName("tools.Dto");
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 String aoId 		= request.getParameter("aoId");
		 String type 		= request.getParameter("type");
		 Double startVal 	= Double.parseDouble(request.getParameter("startVal"));
		 Double endVal 		= Double.parseDouble(request.getParameter("endVal"));
		 Double percentage 	= Double.parseDouble(request.getParameter("percentage"));
	    	
		 Dto param = new Dto();
		 param.putString("aoId", aoId);
		 param.putString("type", type);
		 param.putDouble("startVal", startVal);
		 param.putDouble("endVal", endVal);
		 param.putDouble("percentage", percentage);
		 try {
			 SaveTargetBreakdown.execute(param);
			} catch (Exception e) {
				//e.printStackTrace();
			}
	        response.sendRedirect("/bpr/targetbreakdown");
	 }
	
	 private void editTargetData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
		String id = request.getParameter("id");
		
		Dto selected = browseList.get(id);
		TargetBreakdown set = new TargetBreakdown();
		set = set.getEntity(selected);
		//String registerForm ="vTargetBreakdownForm.jsp";
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("targetbreakdown/vTargetBreakdownForm.jsp");
	 	request.setAttribute("getEdit", set);
	    dispatcher.forward(request, response);
	 }
	 
	 private void updateTargetData(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, SQLException, IOException {
		 
	        String id = request.getParameter("id");
	        String aoId = request.getParameter("aoId");
	        String type = request.getParameter("type");
	        Double startVal = Double.parseDouble(request.getParameter("startVal"));
	        Double endVal = Double.parseDouble(request.getParameter("endVal"));
	        Double percentage 	= Double.parseDouble(request.getParameter("percentage"));
	        
	        Dto param = browseList.get(id);
	        param.putString("aoId", aoId);
	        param.putString("type", type);
	        param.putDouble("startVal", startVal);
	        param.putDouble("endVal", endVal);
	        param.putDouble("percentage", percentage);
	    
	        try {
				SaveTargetBreakdown.execute(param);
			} catch (Exception e) {
				
			}
	        
	        response.sendRedirect("/bpr/targetbreakdown");
		 
	 }
	 
	 private void deleteTargetData(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
		 String id = request.getParameter("id");
		 Dto par = new Dto();
		 par.putString("id", id);
		 Dto targetbreakdownDto = GetTargetBreakdown.execute(par);
		 DeleteTargetBreakdown.execute(targetbreakdownDto);
		 response.sendRedirect("/bpr/targetbreakdown");

	 }
	 
	 private void searchTargetData(HttpServletRequest request, HttpServletResponse response, String key)
	            throws SQLException, IOException, ServletException{
			 
		 List<TargetBreakdown> result = search(request);
		
		 request.setAttribute("resList", result);
	     RequestDispatcher dispatcher = request.getRequestDispatcher("targetbreakdown/vTargetBreakdownList.jsp");
	     dispatcher.forward(request, response);
	 }

	 private List<TargetBreakdown> search(HttpServletRequest request) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String aoId = request.getParameter("aoId");
			String type = request.getParameter("type");
			 
			Dto par = new Dto();
			par.putString("aoId", aoId);
			par.putString("type", type);
			List<TargetBreakdown> result = new ArrayList<TargetBreakdown>();
			
			List<Dto> resultList = GetTargetBreakdownList.execute(par);
		     TargetBreakdown benda = new TargetBreakdown();
			 result = benda.getEntityList(resultList);
			
			 for(Dto item : resultList){
				browseList.put(item.getString("id"), item);
			 }
			return result;
	 }

	 
///	 public void doPost(HttpServletRequest request,
//			  HttpServletResponse response)
//				throws ServletException, IOException {
//				doGet(request,response);
//				
//			}
//			
//			 public void doGet(HttpServletRequest request,
//			            HttpServletResponse response)
//				throws ServletException, IOException {
//						String address = "vTargetBreakdownList.jsp";
//						RequestDispatcher dispatcher =
//						request.getRequestDispatcher(address);
//						dispatcher.forward(request, response);
//					
//			    }
	 
	 
	

}
