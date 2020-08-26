package businessFunction.image;

import java.util.ArrayList;
import java.util.List;

//import org.omg.CORBA.ObjectHelper;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;

public class GetImageList {
	@SuppressWarnings("rawtypes")
	public static List<Dto> execute(Dto param){
		String id = param.getString("id"); 
		String imageName = param.getString("imageName");
		String image = param.getString("image");
		String imageDoc = param.getString("imageDoc");
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID, \n");
		sb.append("    IMAGE_NAME, \n");
		sb.append("    IMAGE, \n");
		sb.append("    IMAGE_DOC \n");
		sb.append("FROM doc_images \n");
		sb.append("WHERE (1=1) \n");
		
		if(!StringHelper.isAll(id)){
			sb.append("AND ID = '"+id+"' \n");
		}
		
		if(!StringHelper.isAll(imageName)){
			sb.append("AND IMAGE_NAME like '%"+imageName+"%' \n");
		}
		
		if(!StringHelper.isAll(image)){
			sb.append("AND IMAGE like '%"+image+"%' \n");
		}
		
		if(!StringHelper.isAll(imageDoc)){
			sb.append("AND IMAGE_DOC like '%"+imageDoc+"%' \n");
		}
		
//		if(image!=null){
//			sb.append("AND IMAGE like '%"+image+"%' \n");
//		}
		
		List<String> keyList = new ArrayList<String>();
		List<Class> classList = new ArrayList<Class>();
		
		keyList.add("id");
		classList.add(String.class);

		keyList.add("imageName");
		classList.add(String.class);

		keyList.add("image");
		classList.add(Object.class);
		
		keyList.add("imageDoc");
		classList.add(String.class);
		
		List<Dto> resList = Connector.selectStatement(sb.toString(), keyList, classList); 
		return resList;
	}

}
