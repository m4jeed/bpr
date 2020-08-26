package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import tools.BaseEntity;
import tools.Dto;

@Entity 
@Table(name="absen")
public class Absen extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID") 
	private String id; 
	
	@Column(name="NAMA")
	private String nama;
	
	@Column(name="CABANG") 
	private String cabang; 
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="TGL")
	private Date tanggal;
	
	public Absen(){
		
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getCabang() {
		return this.cabang;
	}

	public void setCabang(String cabang) {
		this.cabang = cabang;
	}
	
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getTanggal(){
		return this.tanggal;
	}
	
	public void setTanggal(Date tanggal){
		this.tanggal = tanggal;
	}
	
	public Absen getEntity(Dto param){
		Absen result = new Absen();
		result.setId(param.getString("id"));
		result.setNama(param.getString("nama"));
		result.setCabang(param.getString("cabang"));
		result.setStatus(param.getString("status"));
		result.setTanggal((Date) param.getDate("tanggal"));
		
		return result;			
	}
	
	public List<Absen> getEntityList(List<Dto> param){
		ArrayList<Absen> result = new ArrayList<Absen>();
		for(Dto item : param){
			Absen itemRes = getEntity(item);
			result.add(itemRes);
		}
		
		return result;
	}

}
