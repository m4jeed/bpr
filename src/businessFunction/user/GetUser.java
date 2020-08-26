package businessFunction.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;

public class GetUser {
	@SuppressWarnings("rawtypes")
	public static Dto execute(Dto param){ 

		Dto result = new Dto(); 
		String id = param.getString("id"); 

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID, \n");
		sb.append("    USERNAME, \n");
		sb.append("    PASSWORD, \n");
		sb.append("    MAC, \n");
		sb.append("    GRP_APPVL_ID, \n");
		sb.append("    STATUS, \n");
		sb.append("    CREATE_USER, \n");
		sb.append("    CREATE_DATE, \n");
		sb.append("    MOD_USER, \n");
		sb.append("    MODE_DATE, \n");
		sb.append("    VERSION \n");
		sb.append("FROM user \n");
		sb.append("WHERE (1=1) \n");
		
		if(!StringHelper.isAll(id)){
			sb.append("AND ID = '"+id+"' \n");
		}else{
			
			String username = param.getString("username");
//			String grp = param.getString("grp");
//			String mac = param.getString("mac");
			
			sb.append("AND USERNAME = '"+username+"' \n");
//			sb.append("AND GRP_APPVL_ID = '"+grp+"' \n");
//			sb.append("AND MAC = '"+mac+"' \n");
			//sb.append("AND CREATE_DATE = "+createUser+" \n");
		}


		List<String> keyList = new ArrayList<String>();
		List<Class> classList = new ArrayList<Class>();

		keyList.add("id");
		classList.add(String.class);
		
		keyList.add("username");
		classList.add(String.class);

		keyList.add("password");
		classList.add(String.class);

		keyList.add("mac");
		classList.add(String.class);

		keyList.add("grp");
		classList.add(String.class);

		keyList.add("status");
		classList.add(String.class);
		
		keyList.add("createUser");
		classList.add(String.class);
		
		keyList.add("createDate");
		classList.add(Date.class);
		
		keyList.add("modUser");
		classList.add(String.class);
		
		keyList.add("modeDate");
		classList.add(Date.class);
		
		keyList.add("version");
		classList.add(Long.class);

		List<Dto> resList = Connector.selectStatement(sb.toString(), keyList, classList); 
		if(resList!=null){ 
			if(!resList.isEmpty()){ 
				result = resList.get(0);	 
			} 
		} 
		return result; 
	} 

}
