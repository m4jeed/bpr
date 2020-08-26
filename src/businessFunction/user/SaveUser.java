package businessFunction.user;

import entities.User;
import tools.Dto;
import tools.StringHelper;

public class SaveUser {
	
	public static void execute(Dto param){ 

		boolean isAddMode = StringHelper.isAll(param.getString("id")); 

		if(isAddMode){ 

			valBusinessKeyAvailability(param); 

		}else{ 

			valBusinessKeyValidity(param); 
			valBKNotChange(param); 

		} 

		//if error(s) exists.. 

		//save 
		User users = new User(); 
		users.fromDto(param); 
		users.merge(); 

	} 
	
	private static void valBKNotChange(Dto param) { 
		 
	} 

	private static void valBusinessKeyValidity(Dto param) { 
		 
	} 

	private static void valBusinessKeyAvailability(Dto param) { 
		 
	} 

}
