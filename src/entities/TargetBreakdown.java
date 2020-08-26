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
@Table(name="target_breakdown") 
public class TargetBreakdown extends BaseEntity implements Serializable { 
	private static final long serialVersionUID = 1L; 

	
	@Column(name="ID") 
	private String id; 
	
	@Column(name="AO_ID") 
	private String aoId; 

	@Column(name="TYPE") 
	private String type; 

	@Column(name="START_VAL") 
	private Double startVal; 

	@Column(name="END_VAL") 
	private Double endVal; 

	@Column(name="PCT") 
	private Double percentage; 

	public TargetBreakdown() { 
	} 

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAoId() { 
		return this.aoId; 
	} 

	public void setAoId(String aoId) { 
	this.aoId = aoId; 
	} 
	
	public String getType() { 
		return this.type; 
	} 

	public void setType(String type) { 
	this.type = type; 
	} 
	public Double getStartVal() { 
		return this.startVal; 
	} 

	public void setStartVal(Double startVal) { 
	this.startVal = startVal; 
	} 
	public Double getEndVal() { 
		return this.endVal; 
	} 

	public void setEndVal(Double endVal) { 
	this.endVal = endVal; 
	} 
	public Double getPercentage() { 
		return this.percentage; 
	} 

	public void setPercentage(Double percentage) { 
	this.percentage = percentage; 
	} 

	public TargetBreakdown getEntity(Dto param){
		TargetBreakdown result = new TargetBreakdown();
		
		result.setId(param.getString("id"));
		result.setAoId(param.getString("aoId"));
		result.setType(param.getString("type"));
		result.setStartVal(param.getDouble("startVal"));
		result.setEndVal(param.getDouble("endVal"));
		result.setPercentage(param.getDouble("percentage"));
		
		return result;
	}
	
	public List<TargetBreakdown> getEntityList(List<Dto> param){
			ArrayList<TargetBreakdown> result = new ArrayList<TargetBreakdown>();
			for(Dto item : param){
				TargetBreakdown itemRes = getEntity(item);
				result.add(itemRes);
				
			}
			
			return result;
			
		}
	
	

}