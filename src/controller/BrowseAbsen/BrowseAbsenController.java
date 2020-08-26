package controller.BrowseAbsen;

import java.io.IOException;
import java.sql.Date;
//import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.xsom.impl.scd.ParseException;

import businessFunction.absen.GetAbsenList;
import entities.Absen;
import tools.Dto;

public class BrowseAbsenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final DateFormat Calender = null;
	private HashMap<String, Dto> browseList = new HashMap<String, Dto>();
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		 
        try {
        	switch (action) {
        	 case "/searchAbsen":
        		 searchAbsenData(request, response, action);
                 break;
        	 case"/absen":
                 getList(request, response);
                 break;    
        	}
 
        	//resList(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } 
//        catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	private List<Absen> search(HttpServletRequest request) {
		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			String nama = request.getParameter("nama");
			String cabang = request.getParameter("cabang");
			String tanggal =  request.getParameter("tanggal");
//			Date tanggal =  ((Date)request.getParameter("tanggal"));

			 
			Dto par = new Dto();
			par.putString("nama", nama);
			par.putString("cabang", cabang);
			par.putString("tanggal", tanggal);
			List<Absen> result = new ArrayList<Absen>();
			
			List<Dto> resultList = GetAbsenList.execute(par);
			Absen benda = new Absen();
			result = benda.getEntityList(resultList);
			
			for(Dto item : resultList){
				browseList.put(item.getString("id"), item);
			 }
			return result;
	}
	
	private void searchAbsenData(HttpServletRequest request, HttpServletResponse response, String key)
            throws SQLException, IOException, ServletException{
		 
	 List<Absen> result = search(request);
	
	 request.setAttribute("resList", result);
     RequestDispatcher dispatcher = request.getRequestDispatcher("absen/vAbsenList.jsp");
     dispatcher.forward(request, response);
    }
	
	private void getList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		List<Absen> result = search(request);
		
	    request.setAttribute("resList", result);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("absen/vAbsenList.jsp");
	    dispatcher.forward(request, response);
	}

}
