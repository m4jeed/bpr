package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import tools.BaseEntity;
import tools.Dto;

@Entity 
@Table(name="uservsmenu")
public class UserMenu extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID") 
	private String id;
	
	@Column(name="USER_ID") 
	private String userId;
	
	@Column(name="MENU_NAME") 
	private String menuName;
	
	@Column(name="SUB_MENU") 
	private String subMenu;
	
	public UserMenu(){
		
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public String getSubMenu() {
		return this.subMenu;
	}

	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}
	
	public UserMenu getEntity(Dto param){
		UserMenu result = new UserMenu();
		
		result.setId(param.getString("id"));
		result.setUserId(param.getString("userId"));
		result.setMenuName(param.getString("menuName"));
		result.setSubMenu(param.getString("subMenu"));
		
		return result;
	}
	
	public List<UserMenu> getEntityList(List<Dto> param){
		ArrayList<UserMenu> result = new ArrayList<UserMenu>();
		for(Dto item : param){
			UserMenu itemRes = getEntity(item);
			result.add(itemRes);
		}
		return result;
		
	}
}
