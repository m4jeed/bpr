package businessFunction.userMenu;

import java.util.ArrayList;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;

public class GetUserMenu {
	@SuppressWarnings("rawtypes")
	public static Dto execute(Dto param){
		Dto result = new Dto(); 
		String id = param.getString("id");
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID, \n");
		sb.append("    USER_ID, \n");
		sb.append("    MENU_NAME, \n");
		sb.append("    SUB_MENU \n");
		sb.append("FROM uservsmenu \n");
		sb.append("WHERE (1=1) \n");
		
		if(!StringHelper.isAll(id)){
			sb.append("AND ID = '"+id+"' \n");
		}else{
			
			String userId = param.getString("userId");
			String menuName = param.getString("menuName");
			String subMenu = param.getString("subMenu");
			
			sb.append("AND USER_ID = '"+userId+"' \n");
			sb.append("AND MENU_NAME = '"+menuName+"' \n");
			sb.append("AND SUB_MENU = '"+subMenu+"' \n");
			//sb.append("AND CREATE_DATE = "+createUser+" \n");
		}
		
		List<String> keyList = new ArrayList<String>();
		List<Class> classList = new ArrayList<Class>();
		
		keyList.add("id");
		classList.add(String.class);
		
		keyList.add("userId");
		classList.add(String.class);
		
		keyList.add("menuName");
		classList.add(String.class);
		
		keyList.add("subMenu");
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
