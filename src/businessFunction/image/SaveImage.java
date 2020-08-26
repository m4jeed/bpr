package businessFunction.image;

import entities.Image;
import tools.Dto;
import tools.StringHelper;

public class SaveImage {
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
		Image imgPicture = new Image(); 
		imgPicture.fromDto(param); 
		imgPicture.merge(); 

	} 
	
	private static void valBKNotChange(Dto param) { 
		 
	} 

	private static void valBusinessKeyValidity(Dto param) { 
		 
	} 

	private static void valBusinessKeyAvailability(Dto param) { 
		 
	}

}
