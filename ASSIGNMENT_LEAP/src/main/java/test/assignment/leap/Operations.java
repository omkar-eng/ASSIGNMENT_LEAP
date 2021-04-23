package test.assignment.leap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




//Operations Class for CRD operations.
public class Operations {

	
	// Read the Json objects from the data store file and change it to Java MapHandling class type.
	public Map<String,Employee> retrieveJson(String path,MapHandling mapHandling) {
		
		ObjectMapper mapper = new ObjectMapper();
		MapHandling details = null;
		try {
			File file = new File(path);
			
			details = mapper.readValue(file, MapHandling.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return details.getMapHandling();
		
	}
	
	//Check for Json object value size.
	public boolean jsonSize(Employee employee) {
		
		int size = 16 * 1024; 
		try {
			
			String json = new ObjectMapper().writeValueAsString(employee);

			if (determineStringBytes(json) > size) {
				return false;
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	public long determineStringBytes(String value) {
		return value.getBytes().length;
	}
	
	
	// Write the Json objects in the specified file path.
	public void create(String path,MapHandling mapHandling) {
		
		File file = new File(path);

		// Converts hash map objects to Json objects by passing college object.
		String jsonObject = mapObjectToJsonObject(mapHandling);

		PrintWriter writer;
		try {
			
			writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			writer.println(jsonObject);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Provides a Json string formatted mapHandling object.
	private String mapObjectToJsonObject(Object object) {
		String jsonString = "";
		try {
			
			jsonString = new ObjectMapper().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}


}
