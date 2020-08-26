package controller.BrowseKunjungan;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import businessFunction.kunjungan.DeleteKunjungan;
import businessFunction.kunjungan.GetKunjungan;
import businessFunction.kunjungan.GetKunjunganList;
import businessFunction.kunjungan.SaveKunjungan;
import entities.GridExporter;
import entities.Kunjungan;
import tools.Dto;
import tools.StringHelper;


@MultipartConfig(fileSizeThreshold=1024*1024*10, //10MB
maxFileSize=1024*1024*10, //10MB
maxRequestSize=1024*1024*50)
public class BrowseKunjunganController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Dto> browseList = new HashMap<String, Dto>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		 
        try {
        	switch (action) {
        	 case "/searchKunjungan":
        		 getList(request, response);
                 break;
        	 case"/kunjungan":
                 getList(request, response);
                 break; 
        	 case"/newDataKunjungan":
        		 showKunjunganForm(request, response);
                 break; 
        	 case"/prosesDataKunjungan":
        		 insertKunjunganData(request, response);
                 break;
        	 case "/editDataKunjungan":
                 editKunjunganData(request, response);
                 break;
        	 case "/deleteDataKunjungan":
                 deleteKunjunganData(request, response);
                 break;
        	}
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void getList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession(); 
		String tglKunjungan = request.getParameter("tglKunjungan");
		String namaMarketing =  request.getParameter("namaMarketing");
		String namaDebitur =  request.getParameter("namaDebitur");
		String id = (String) session.getAttribute("id");
		
		Dto par = new Dto();
		par.putString("tglKunjungan", tglKunjungan);
		par.putString("namaMarketing", namaMarketing);
		par.putString("namaDebitur", namaDebitur);
		par.putString("id", id);
		
		List<Dto> resultList = GetKunjunganList.execute(par);
		
		List<String> columnHeader = Arrays.asList(
        		"Id", "Tipe", "Tanggal", "Marketing", "Debitur", "Hasil", "Janji","Aksi");
        List<String> keyList = Arrays.asList(
        		"id","tipe", "tglKunjungan", "namaMarketing", "namaDebitur", "hasilKunjungan", "tglJanji");
        List<Class> columnClass = Arrays.asList(
        		java.lang.String.class, java.lang.String.class, java.util.Date.class, java.lang.String.class, java.lang.String.class,
        		java.lang.String.class, java.util.Date.class);
		
		GridExporter grid = new GridExporter(columnHeader, keyList, columnClass);
		grid.putResult(resultList);
		
	    request.setAttribute("export", grid);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("kunjungan/vKujunganList.jsp");
	    dispatcher.forward(request, response);
	    
	}
	
	private void showKunjunganForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 
        RequestDispatcher dispatcher = request.getRequestDispatcher("kunjungan/vKunjunganForm.jsp");
        dispatcher.forward(request, response);
	}
	
	private void insertKunjunganData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException, ServletException {
		
		 String copyPath = "D:/Penting/BPR/bpr/WebContent/dokumen/";
		 String tipe 			= request.getParameter("tipe");
		 String DateKunjungan   = request.getParameter("tglKunjungan");
		 String namaMarketing   = request.getParameter("namaMarketing");
		 String namaDebitur 	= request.getParameter("namaDebitur");
		 String noPinjaman 	    = request.getParameter("noPinjaman");
		 String hasilKunjungan  = request.getParameter("hasilKunjungan");
		 String DateJanji		= request.getParameter("tglJanji");
		 String petugas			= request.getParameter("petugas");
		 
		 Dto param = new Dto();
		 String id = request.getParameter("id");
		 if(!StringHelper.isAll(id)){
			 Dto par = new Dto();
			 par.putString("id", id);
			 param = GetKunjungan.execute(par);
				
			 List<Dto> resultList = GetKunjunganList.execute(par);
			 for(Dto item : resultList){
				browseList.put(item.getString("id"), item);
			 }
		    
		     Dto selected = browseList.get(id);
		     Kunjungan set = new Kunjungan();
		     set = set.getEntity(selected);
		     File deletFile = new File(copyPath, set.getGambar());
	    	 deletFile.delete();
		 }
		 
	     try{
	    	 Part part       = request.getPart("gambar");
		     String fileName = extractFileName(part);
	    	 String fullPath = copyPath + fileName;
		     String filePath = fileName;
		     Pattern p = Pattern.compile("(.*?)(\\d+)?(\\..*)?");//buat duplicat saat insert nama image sama
	    	 while(new File(fullPath).exists()){
			     Matcher m = p.matcher(fullPath);
			     if(m.matches()){
			    	 fullPath = m.group(1) + (m.group(2)==null?1:(Integer.parseInt(m.group(2)) + 1)) + (m.group(3)==null?"":m.group(3)); 	 
			     }
			     Pattern f = Pattern.compile("(.*?)(\\d+)?(\\..*)?");
		    	 do{
		    	     Matcher n = f.matcher(filePath);
		    	     if(n.matches()){
		    	    	 filePath = n.group(1) + (n.group(2)==null?1:(Integer.parseInt(n.group(2)) + 1)) + (n.group(3)==null?"":n.group(3));
		    	     }
		    	 }while(new File(filePath).exists());
		    	 
			     
			 }
	    	 part.write(fullPath);
	    	 param.putString("gambar", filePath);

		}catch(Exception e){
		}
				
		try{
			if(DateKunjungan != "0"){
		    	 SimpleDateFormat dateK = new SimpleDateFormat("yyyy-MM-dd");
				 Date tglKunjungan = dateK.parse(DateKunjungan); 
				 
				 param.putDate("tglKunjungan", tglKunjungan);
		     }
			
		}catch(Exception e){
		}
				
		try{
			if(DateJanji != "0"){
				 SimpleDateFormat dateJ = new SimpleDateFormat("yyyy-MM-dd");
				 Date tglJanji     = dateJ.parse(DateJanji);
				 
				 param.putDate("tglJanji", tglJanji);
		     }
			
		}catch(Exception e){
		}
				
	     param.putString("tipe", tipe);
		 param.putString("namaMarketing", namaMarketing);
		 param.putString("namaDebitur", namaDebitur);
		 param.putString("noPinjaman", noPinjaman);
		 param.putString("hasilKunjungan", hasilKunjungan);
		 param.putString("petugas", petugas);
	     try {
			Class.forName("tools.Dto");
			Class.forName("com.mysql.jdbc.Driver");
			SaveKunjungan.execute(param);
		 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		 }

	     response.sendRedirect("/bpr/kunjungan");
		
	}
	
	private String extractFileName (Part part){
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s : items){
			if(s.trim().startsWith("filename")){
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
	
	private void editKunjunganData(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, SQLException, IOException {
		
			String id = request.getParameter("id");
			
			Dto par = new Dto();
			par.putString("id", id);
			
			List<Dto> resultList = GetKunjunganList.execute(par);
			
			for(Dto item : resultList){
				browseList.put(item.getString("id"), item);
			}
			
			Dto selected = browseList.get(id);
		    Kunjungan set = new Kunjungan();
		    set = set.getEntity(selected);
		    
		 	RequestDispatcher dispatcher = request.getRequestDispatcher("kunjungan/vKunjunganForm.jsp");
		 	request.setAttribute("getEdit", set);
		    dispatcher.forward(request, response);
	 }
	
	 private void deleteKunjunganData(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
		 
            String id = request.getParameter("id");
            Dto par = new Dto();
			par.putString("id", id); 
			
			List<Dto> resultList = GetKunjunganList.execute(par);
			for(Dto item : resultList){
				browseList.put(item.getString("id"), item);
			}
		    
		    Dto selected = browseList.get(id);
		    Kunjungan set = new Kunjungan();
		    set = set.getEntity(selected);
		    
		    try {
		    	File deletFile = new File("D:/Penting/BPR/bpr/WebContent/dokumen/"+ set.getGambar());
		    	deletFile.delete();
//		    	if(deletFile.delete()) { 
//	                System.out.println("Delete success");
//	             } else {
//	                System.out.println("Delete operation is failed.");
//	             } 
				Dto kunDto = GetKunjungan.execute(par);
				DeleteKunjungan.execute(kunDto);
		    }catch(Exception e){
                System.out.println("Failed to Delete image !!");
            }
		    
			response.sendRedirect("/bpr/kunjungan");
	 }
	 
}
