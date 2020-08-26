package businessFunction.userMenu;

import entities.UserMenu;
import tools.Dto;
import tools.StringHelper;

public class SaveUserMenu {
	public static void execute(Dto param){ 
		boolean isAddMode = StringHelper.isAll(param.getString("id"));
		if(isAddMode){ 

			valBusinessKeyAvailability(param); 

		}else{ 

			valBusinessKeyValidity(param); 
			valBKNotChange(param); 

		} 
		
		UserMenu usermenu = new UserMenu();
		usermenu.fromDto(param);
		usermenu.merge();
		
		
	}
	
	private static void valBKNotChange(Dto param) { 
		 
	} 

	private static void valBusinessKeyValidity(Dto param) { 
		 
	} 

	private static void valBusinessKeyAvailability(Dto param) { 
		 
	} 
	
}
