package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tools.BaseEntity;
import tools.Dto;

@Entity
@Table(name="kunjungan")
public class Kunjungan extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Column(name="ID") 
	private String id; 
	
	@Column(name="TIPE")
	private String tipe;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TGL_KUNJUNGAN") 
	private Date tglKunjungan;
	
	@Column(name="NAMA_MARKETING")
	private String namaMarketing;
	
	@Column(name="NAMA_DEBITUR")
	private String namaDebitur;
	
	@Column(name="NO_PINJAMAN")
	private String noPinjaman;
	
	@Column(name="HASIL_KUNJUNGAN")
	private String hasilKunjungan;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TGL_JANJI")
	private Date tglJanji;
	
	@Column(name="PETUGAS")
	private String petugas;
	
	@Column(name="GAMBAR")
	private String gambar;
	
	public Kunjungan() {
		
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTipe() {
		return this.tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}
	
	public Date getTglKunjungan() {
		return this.tglKunjungan;
	}

	public void setTglKunjungan(Date tglKunjungan) {
		this.tglKunjungan = tglKunjungan;
	}
	
	public String getNamaMarketing() {
		return this.namaMarketing;
	}

	public void setNamaMarketing(String namaMarketing) {
		this.namaMarketing = namaMarketing;
	}
	
	public String getNamaDebitur() {
		return this.namaDebitur;
	}

	public void setNamaDebitur(String namaDebitur) {
		this.namaDebitur = namaDebitur;
	}
	
	public String getNoPinjaman() {
		return this.noPinjaman;
	}

	public void setNoPinjaman(String noPinjaman) {
		this.noPinjaman = noPinjaman;
	}
	
	public String getHasilKunjungan() {
		return this.hasilKunjungan;
	}

	public void setHasilKunjungan(String hasilKunjungan) {
		this.hasilKunjungan = hasilKunjungan;
	}
	
	public Date getTglJanji() {
		return this.tglJanji;
	}

	public void setTglJanji(Date tglJanji) {
		this.tglJanji = tglJanji;
	}
	
	public String getPetugas() {
		return this.petugas;
	}
	
	public void setPetugas(String petugas) {
		this.petugas = petugas;
	}
	
	public String getGambar() {
		return this.gambar;
	}
	
	public void setGambar(String gambar) {
		this.gambar = gambar;
	}
	
	public Kunjungan getEntity(Dto param){
		Kunjungan result = new Kunjungan();
		
		result.setId(param.getString("id"));
		result.setTipe(param.getString("tipe"));
		result.setTglKunjungan((Date) param.getDate("tglKunjungan"));
		result.setNamaMarketing(param.getString("namaMarketing"));
		result.setNamaDebitur(param.getString("namaDebitur"));
		result.setNoPinjaman(param.getString("noPinjaman"));
		result.setHasilKunjungan(param.getString("hasilKunjungan"));
		result.setTglJanji((Date) param.getDate("tglJanji"));
		result.setPetugas(param.getString("petugas"));
		result.setGambar(param.getString("gambar"));
//		result.setGambar("/bprcf/dokumen/Hydrangeas.jpg");
		
		return result;
		
	}
	
	public List<Kunjungan> getEntityList(List<Dto> param){
		ArrayList<Kunjungan> result = new ArrayList<Kunjungan>();
		
		for(Dto item : param){
			Kunjungan itemRes = getEntity(item);
			result.add(itemRes);
			
		}
		
		return result;
	}

}
