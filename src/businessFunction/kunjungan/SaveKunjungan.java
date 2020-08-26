package businessFunction.kunjungan;

import entities.Kunjungan;
import tools.Dto;
import tools.StringHelper;

public class SaveKunjungan {
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
		Kunjungan save = new Kunjungan(); 
		save.fromDto(param); 
		save.merge(); 

	} 

	private static void valBKNotChange(Dto param) { 
		 
	} 

	private static void valBusinessKeyValidity(Dto param) { 
		 
	} 

	private static void valBusinessKeyAvailability(Dto param) { 
		 
	}

}
