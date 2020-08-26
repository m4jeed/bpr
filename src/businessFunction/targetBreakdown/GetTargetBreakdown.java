package businessFunction.targetBreakdown; 

import java.util.ArrayList;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper; 

public class GetTargetBreakdown { 

	@SuppressWarnings("rawtypes")
	public static Dto execute(Dto param){ 

		Dto result = new Dto(); 
		String id = param.getString("id"); 

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID, \n");
		sb.append("    AO_ID, \n");
		sb.append("    TYPE, \n");
		sb.append("    START_VAL, \n");
		sb.append("    END_VAL, \n");
		sb.append("    PCT \n");
		sb.append("FROM target_breakdown \n");
		sb.append("WHERE (1=1) \n");
		
		if(!StringHelper.isAll(id)){
			sb.append("AND ID = '"+id+"' \n");
		}else{
			
			String aoId = param.getString("aoId");
			String type = param.getString("type");
			Double startVal = param.getDouble("startVal");
			
			sb.append("AND AO_ID = '"+aoId+"' \n");
			sb.append("AND TYPE = '"+type+"' \n");
			sb.append("AND START_VAL = "+startVal+" \n");
		}


		List<String> keyList = new ArrayList<String>();
		List<Class> classList = new ArrayList<Class>();

		keyList.add("id");
		classList.add(String.class);
		
		keyList.add("aoId");
		classList.add(String.class);

		keyList.add("type");
		classList.add(String.class);

		keyList.add("startVal");
		classList.add(Double.class);

		keyList.add("endVal");
		classList.add(Double.class);

		keyList.add("percentage");
		classList.add(Double.class);

		List<Dto> resList = Connector.selectStatement(sb.toString(), keyList, classList); 
		if(resList!=null){ 
			if(!resList.isEmpty()){ 
				result = resList.get(0);	 
			} 
		} 
		return result; 
	} 
} 
