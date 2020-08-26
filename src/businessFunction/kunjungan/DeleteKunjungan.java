package businessFunction.kunjungan;

import entities.Kunjungan;
import tools.Dto;
import tools.ErrManager;

public class DeleteKunjungan {
	public static void execute(Dto param){
		Dto kunDto = GetKunjungan.execute(param);
		if(kunDto.isEmpty()){ 
			ErrManager.error("Data tidak terdaftar");
		}else{ 
			Kunjungan deleted = new Kunjungan(); 
			deleted.fromDto(param); 
			deleted.remove(); 

		}
	}

}
