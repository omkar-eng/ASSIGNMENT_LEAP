package test.assignment.leap;

import java.util.HashMap;
import java.util.Map;


//POJO class of MapHandling.
public class MapHandling {

	//variable of MapHandling class.
	private Map<String,Employee> mapHandling=new HashMap<String,Employee>();

	//Getter and Setter.
	public Map<String, Employee> getMapHandling() {
		return mapHandling;
	}

	public void setMapHandling(Map<String, Employee> mapHandling) {
		this.mapHandling = mapHandling;
	}
	
	
}
