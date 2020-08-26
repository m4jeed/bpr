package businessFunction.image;

import java.util.ArrayList;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;

public class GetImage {
	
	@SuppressWarnings("rawtypes")
	public static Dto execute(Dto param){ 

		Dto result = new Dto(); 
		String id = param.getString("id"); 
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID, \n");
		sb.append("    IMAGE_NAME, \n");
		sb.append("    IMAGE_DOC \n");
		sb.append("FROM doc_images \n");
		sb.append("WHERE (1=1) \n");
		
		if(!StringHelper.isAll(id)){
			sb.append("AND ID = '"+id+"' \n");
		}else{
			
			String imageName 			= param.getString("imageName");
			sb.append("AND TIPE = '"+imageName+"' \n");
		}


		List<String> keyList = new ArrayList<String>();
		List<Class> classList = new ArrayList<Class>();

		keyList.add("id");
		classList.add(String.class);
		
		keyList.add("imageName");
		classList.add(String.class);

//		keyList.add("tglKunjungan");
//		classList.add(Date.class);
		
		keyList.add("imageDoc");
		classList.add(String.class);
		

		List<Dto> resList = Connector.selectStatement(sb.toString(), keyList, classList); 
		if(resList!=null){ 
			if(!resList.isEmpty()){ 
				result = resList.get(0);	 
			} 
		} 
		return result; 
	}

}
