package businessFunction.user;

import entities.User;
import tools.Dto;
import tools.ErrManager;

public class DeleteUser {
	
	public static void execute(Dto param){
		Dto userDto = GetUser.execute(param);
		if(userDto.isEmpty()){ 
			ErrManager.error("Data tidak terdaftar");
		}else{ 

			User entity = new User(); 
			entity.fromDto(param); 
			entity.remove(); 

		}
	}

}
