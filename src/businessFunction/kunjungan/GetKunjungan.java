package businessFunction.kunjungan;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;

public class GetKunjungan {
	@SuppressWarnings("rawtypes")
	public static Dto execute(Dto param){ 

		Dto result = new Dto(); 
		String id = param.getString("id"); 
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID, \n");
		sb.append("    TIPE, \n");
		sb.append("    TGL_KUNJUNGAN, \n");
		sb.append("    NAMA_MARKETING, \n");
		sb.append("    NAMA_DEBITUR, \n");
		sb.append("    NO_PINJAMAN, \n");
		sb.append("    HASIL_KUNJUNGAN, \n");
		sb.append("    TGL_JANJI, \n");
		sb.append("    PETUGAS, \n");
		sb.append("    GAMBAR \n");
		sb.append("FROM kunjungan \n");
		sb.append("WHERE (1=1) \n");
		
		if(!StringHelper.isAll(id)){
			sb.append("AND ID = '"+id+"' \n");
		}else{
			
			String tipe 			= param.getString("tipe");
			String tglKunjungan 	= param.getString("tglKunjungan");
			String namaMarketing 	= param.getString("namaMarketing");
			String namaDebitur 		= param.getString("namaDebitur");
			String hasilKunjungan 	= param.getString("hasilKunjungan");
			String tglJanji 		= param.getString("tglJanji");
			//String gambar 		    = param.getString("gambar");
			
			sb.append("AND TIPE = '"+tipe+"' \n");
			sb.append("AND TGL_KUNJUNGAN = '"+tglKunjungan+"' \n");
			sb.append("AND NAMA_MARKETING = '"+namaMarketing+"' \n");
			sb.append("AND NAMA_DEBITUR = '"+namaDebitur+"' \n");
			sb.append("AND HASIL_KUNJUNGAN = '"+hasilKunjungan+"' \n");
			sb.append("AND TGL_JANJI = "+tglJanji+" \n");
			//sb.append("AND GAMBAR = "+gambar+" \n");
		}


		List<String> keyList = new ArrayList<String>();
		List<Class> classList = new ArrayList<Class>();

		keyList.add("id");
		classList.add(String.class);
		
		keyList.add("tipe");
		classList.add(String.class);

		keyList.add("tglKunjungan");
		classList.add(Date.class);

		keyList.add("namaMarketing");
		classList.add(String.class);

		keyList.add("namaDebitur");
		classList.add(String.class);

		keyList.add("noPinjaman");
		classList.add(String.class);
		
		keyList.add("hasilKunjungan");
		classList.add(String.class);
		
		keyList.add("tglJanji");
		classList.add(Date.class);
		
		keyList.add("petugas");
		classList.add(String.class);
		
		keyList.add("gambar");
		classList.add(String.class);
		

		List<Dto> resList = Connector.selectStatement(sb.toString(), keyList, classList); 
		if(resList!=null){ 
			if(!resList.isEmpty()){ 
				result = resList.get(0);	 
			} 
		} 
		return result; 
	} 

}
