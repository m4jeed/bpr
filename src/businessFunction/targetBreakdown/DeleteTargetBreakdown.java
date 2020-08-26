package businessFunction.targetBreakdown; 

import entities.TargetBreakdown;
import tools.Dto;
import tools.ErrManager; 


public class DeleteTargetBreakdown { 

	public static void execute(Dto param){ 
		Dto targetbreakdownDto = GetTargetBreakdown.execute(param); 

		if(targetbreakdownDto.isEmpty()){ 
			ErrManager.error("Data tidak terdaftar");
		}else{ 

			TargetBreakdown entity = new TargetBreakdown(); 
			entity.fromDto(param); 
			entity.remove(); 

		}
	}
}