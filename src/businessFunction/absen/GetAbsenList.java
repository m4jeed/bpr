package businessFunction.absen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;

public class GetAbsenList {
	
	@SuppressWarnings("rawtypes")
	public static List<Dto> execute(Dto param) { 
		
		String id 	= param.getString("id");
		String nama 	= param.getString("nama");
		String cabang 	= param.getString("cabang");
		Date tanggal 	= param.getDate("tanggal");
		
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
		}
		
		if(!StringHelper.isAll(nama)){
			sb.append("AND NAMA like '%"+nama+"%' \n");
		}
		
		if(!StringHelper.isAll(cabang)){
			sb.append("AND CABANG like '%"+cabang+"%' \n");
		}
		
		if(tanggal!=null){
			sb.append("AND TGL = "+tanggal+" \n");
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
		return resList; 
		
	}

}
