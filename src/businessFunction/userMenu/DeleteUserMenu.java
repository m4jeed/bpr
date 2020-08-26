package businessFunction.userMenu;

import entities.UserMenu;
import tools.Dto;
import tools.ErrManager;

public class DeleteUserMenu {
	public static void execute(Dto param){
		Dto usermenuDto = GetUserMenu.execute(param);
		if(usermenuDto.isEmpty()){
			ErrManager.error("Data tidak terdaftar");
		}else{
			UserMenu entity= new UserMenu();
			entity.fromDto(param); 
			entity.remove(); 
		}
		
	}

}
