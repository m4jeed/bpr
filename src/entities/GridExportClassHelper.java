package entities;

public class GridExportClassHelper {
	
	public Object value;
	public String type;
	
	public GridExportClassHelper(Object val, String typ){
		setValue(val);
		setType(typ);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
