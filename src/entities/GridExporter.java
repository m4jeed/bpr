package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tools.Dto;

public class GridExporter {
	
	public List<String> headerList;
	public List<String> keyList;
	public List<String> classList;
	public List<List<GridExportClassHelper>> dataList;
	
	@SuppressWarnings("rawtypes")
	public GridExporter(List<String> colHeader, List<String> keyHeader, List<Class> classHeader){
		
		headerList = new ArrayList<String>();
		keyList = new ArrayList<String>();
		classList = new ArrayList<String>();
		
		setHeaderList(colHeader);
		setKeyList(keyHeader);
		
		for(Class item : classHeader){
			if(item.equals(String.class)){
				classList.add("String");
 			}else if (item.equals(Double.class)) {
 				classList.add("Double");
			}else if (item.equals(Integer.class)) {
				classList.add("Integer");
			}else if (item.equals(Long.class)) {
				classList.add("Long");
			}else if (item.equals(Boolean.class)) {
				classList.add("Boolean");
			}else if (item.equals(Date.class)) {
				classList.add("Date");
			}
		}
		
	}
	
	public void putResult(List<Dto> result){
		
		dataList = new ArrayList<List<GridExportClassHelper>>();
		
		//String[] par = new String[6];
		for(Dto item : result){
			List<GridExportClassHelper> row = new ArrayList<GridExportClassHelper>();
			for(int i=0; i<keyList.size(); i++){
				GridExportClassHelper newItem = null;
				if("String".equals(classList.get(i))){
					newItem = new GridExportClassHelper(item.getString(keyList.get(i)), "String");
	 			}else if ("Double".equals(classList.get(i))) {
	 				newItem = new GridExportClassHelper(item.getDouble(keyList.get(i)), "Double");
				}else if ("Integer".equals(classList.get(i))) {
					newItem = new GridExportClassHelper(item.getInteger(keyList.get(i)), "Integer");
				}else if ("Long".equals(classList.get(i))) {
					newItem = new GridExportClassHelper(item.getLong(keyList.get(i)), "Long");
				}else if ("Boolean".equals(classList.get(i))) {
					newItem = new GridExportClassHelper(item.getBoolean(keyList.get(i)), "Boolean");
				}else if ("Date".equals(classList.get(i))) {
					newItem = new GridExportClassHelper(item.getDate(keyList.get(i)), "Date");
				}
				row.add(newItem);
			}
			dataList.add(row);
		}
		
	}

	public List<String> getHeaderList() {
		return headerList;
	}

	public void setHeaderList(List<String> headerList) {
		this.headerList = headerList;
	}

	public List<String> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}

	public List<String> getClassList() {
		return classList;
	}

	public void setClassList(List<String> classList) {
		this.classList = classList;
	}

	public List<List<GridExportClassHelper>> getDataList() {
		return dataList;
	}

	public void setDataList(List<List<GridExportClassHelper>> dataList) {
		this.dataList = dataList;
	}

	


}
