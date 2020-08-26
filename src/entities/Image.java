package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.annotation.MultipartConfig;

import tools.BaseEntity;
import tools.Dto;

@Entity 
@Table(name="doc_images")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class Image extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID") 
	private String id; 
	
	@Column(name="IMAGE_NAME")
	private String imageName;
	
	@Column(name="IMAGE") 
	private Object image; 
	
	@Column(name="IMAGE_DOC")
	private String imageDoc;
	
	public Image() {
		
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public Object getImage() {
		return this.image;
	}

	public void setImage(Object image) {
		this.image = image;
	}
	
	public String getImageDoc() {
		return this.imageDoc;
	}

	public void setImageDoc(String imageDoc) {
		this.imageDoc = imageDoc;
	}
	
	public Image getEntity(Dto param){
		Image result = new Image();
		result.setId(param.getString("id"));
		result.setImageName(param.getString("imageName"));
		result.setImage(param.getObject("image"));
		result.setImageDoc(param.getString("imageDoc"));
		return result;
	}
	
	public List<Image> getEntityList(List<Dto> param){
		ArrayList<Image> result = new ArrayList<Image>();
		for(Dto item : param){
			Image itemRes = getEntity(item);
			result.add(itemRes);
		}
		
		return result;
	}
	
}
