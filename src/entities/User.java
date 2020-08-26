package entities;
import java.io.Serializable;
import java.sql.Date;
//import java.util.Date
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import tools.BaseEntity;
import tools.Dto; 


@Entity 
@Table(name="user")
public class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID") 
	private String id; 
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="MAC")
	private String mac;
	
	@Column(name="GRP_APPVL_ID")
	private String grp;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="CREATE_USER")
	private String createUser;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="MOD_USER")
	private String modUser;
	
	@Column(name="MODE_DATE")
	private Date modeDate;
	
	@Column(name="VERSION")
	private Long version;
	
	public User(){
		
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getMac(){
		return this.mac;
	}
	
	public void setMac(String mac){
		this.mac = mac;
	}
	
	public String getGrp(){
		return this.grp;
	}
	
	public void setGrp(String grp){
		this.grp = grp;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getCreatUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	public Date getCreateDate(){
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
	public String getModUser(){
		return this.modUser;
	}
	
	public void setModUser(String modUser){
		this.modUser = modUser;
	}
	
	public Date getModeDate(){
		return this.modeDate;
	}
	
	public void setModeDate(Date modeDate){
		this.modeDate = modeDate;
	}
	
	
	public Long getVersion(){
		return this.version;
	}
	
	public void setVersion(Long version){
		this.version = version;
	}
	
	public User getEntity(Dto param){
		User result = new User();
		
		result.setId(param.getString("id"));
		result.setUsername(param.getString("username"));
		result.setPassword(param.getString("password"));
		result.setMac(param.getString("mac"));
		result.setGrp(param.getString("grp"));
		result.setStatus(param.getString("status"));
		result.setCreateUser(param.getString("createUser"));
		result.setCreateDate((Date) param.getDate("createDate"));
		result.setModUser(param.getString("modUser"));
		result.setModeDate((Date)param.getDate("modeDate"));
		result.setVersion(param.getLong("version"));
		
		return result;
	}
	
	public List<User> getEntityList(List<Dto> param){
		ArrayList<User> result = new ArrayList<User>();
		for(Dto item : param){
			User itemRes = getEntity(item);
			result.add(itemRes);
			
		}
		
		return result;
		
	}
}
