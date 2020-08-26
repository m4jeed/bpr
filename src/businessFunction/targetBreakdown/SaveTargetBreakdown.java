package businessFunction.targetBreakdown; 
import entities.TargetBreakdown;
import tools.Dto;
import tools.StringHelper; 

public class SaveTargetBreakdown { 

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
		TargetBreakdown targetBreakdown = new TargetBreakdown(); 
		targetBreakdown.fromDto(param); 
		targetBreakdown.merge(); 

	} 

	private static void valBKNotChange(Dto param) { 
		 
	} 

	private static void valBusinessKeyValidity(Dto param) { 
		 
	} 

	private static void valBusinessKeyAvailability(Dto param) { 
		 
	} 
} 
