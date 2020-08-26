package businessFunction.kunjungan;

import java.util.ArrayList;
import java.util.List;

import tools.Connector;
import tools.Dto;
import tools.StringHelper;
import java.util.Date;

public class GetKunjunganList {
	@SuppressWarnings("rawtypes")
	public static List<Dto> execute(Dto param){ 

		String id 				= param.getString("id"); 
		String tipe 			= param.getString("tipe");
		Date tglKunjungan 		= param.getDate("tglKunjungan");
		String namaMarketing 	= param.getString("namaMarketing");
		String namaDebitur 	    = param.getString("namaDebitur");
		String hasilKunjungan 	= param.getString("hasilKunjungan");
		Date tglJanji 			= param.getDate("tglJanji");

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
		}
		
		if(!StringHelper.isAll(tipe)){
			sb.append("AND TIPE like '%"+tipe+"%' \n");
		}
		
		if(tglKunjungan!=null){
			sb.append("AND TGL_KUNJUNGAN = "+tglKunjungan+" \n");
		}
		
		if(!StringHelper.isAll(namaMarketing)){
			sb.append("AND NAMA_MARKETING like '%"+namaMarketing+"%' \n");
		}
		
		if(!StringHelper.isAll(namaDebitur)){
			sb.append("AND NAMA_DEBITUR like '%"+namaDebitur+"%' \n");
		}
		
		if(!StringHelper.isAll(hasilKunjungan)){
			sb.append("AND HASIL_KUNJUNGAN like '%"+hasilKunjungan+"%' \n");
		}
		
		if(tglJanji!=null){
			sb.append("AND TGL_JANJI = "+tglJanji+" \n");
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
		return resList; 
	} 

}
