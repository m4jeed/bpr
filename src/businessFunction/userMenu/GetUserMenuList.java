package businessFunction.userMenu;

import java.util.ArrayList;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;

public class GetUserMenuList {
	@SuppressWarnings("rawtypes")
	
	public static List<Dto> execute(Dto param){
		String id = param.getString("id"); 
		String userId = param.getString("userId");
		String menuName = param.getString("menuName");
		String subMenu = param.getString("subMenu");
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID, \n");
		sb.append("    USER_ID, \n");
		sb.append("    MENU_NAME, \n");
		sb.append("    SUB_MENU \n");
		sb.append("FROM uservsmenu \n");
		sb.append("WHERE (1=1) \n");
		
		if(!StringHelper.isAll(id)){
			sb.append("AND ID = '"+id+"' \n");
		}
		
		if(!StringHelper.isAll(userId)){
			sb.append("AND USER_ID like '%"+userId+"%' \n");
		}
		
		if(!StringHelper.isAll(menuName)){
			sb.append("AND MENU_NAME like '%"+menuName+"%' \n");
		}
		
		if(!StringHelper.isAll(subMenu)){
			sb.append("AND SUB_MENU like '%"+subMenu+"%' \n");
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
		return resList;
		
		
	}
}
