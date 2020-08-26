package businessFunction.absen;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;

public class GetAbsen {
	@SuppressWarnings("rawtypes")
	
	public static Dto execute(Dto param){ 
		Dto result = new Dto(); 
		String id = param.getString("id"); 
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID, \n");
		sb.append("    NAMA, \n");
		sb.append("    CABANG, \n");
		sb.append("    STATUS, \n");
		sb.append("    TGL \n");
		sb.append("FROM absen \n");
		sb.append("WHERE (1=1) \n");
		if(!StringHelper.isAll(id)){
			sb.append("AND ID = '"+id+"' \n");
		}else{
			
			String nama 	= param.getString("nama");
			String cabang 	= param.getString("cabang");
			Date tanggal 	= param.getDate("tanggal");
			
			sb.append("AND NAMA = '"+nama+"' \n");
			sb.append("AND CABANG = '"+cabang+"' \n");
			sb.append("AND TGL = '"+tanggal+"' \n");
		}
		
		List<String> keyList = new ArrayList<String>();
		List<Class> classList = new ArrayList<Class>();
		
		keyList.add("id");
		classList.add(String.class);
		
		keyList.add("nama");
		classList.add(String.class);
		
		keyList.add("cabang");
		classList.add(String.class);
		
		keyList.add("status");
		classList.add(String.class);
		
		keyList.add("tanggal");
		classList.add(Date.class);
		
		List<Dto> resList = Connector.selectStatement(sb.toString(), keyList, classList); 
		if(resList!=null){ 
			if(!resList.isEmpty()){ 
				result = resList.get(0);	 
			} 
		} 
		return result;
		
	}

}
