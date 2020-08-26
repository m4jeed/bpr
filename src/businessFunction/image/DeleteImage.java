package businessFunction.image;

import entities.Image;
import tools.Dto;
import tools.ErrManager;

public class DeleteImage {
	
	public static void execute(Dto param){
		Dto kunDto = GetImage.execute(param);
		if(kunDto.isEmpty()){ 
			ErrManager.error("Data tidak terdaftar");
		}else{ 
			Image deleted = new Image(); 
			deleted.fromDto(param); 
			deleted.remove(); 

		}
	}

}
