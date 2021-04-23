package test.assignment.leap;

import java.util.Map;


//class for delete the data.
public class DeleteData {

public void delete(String empId, Map<String,Employee> map) {
		
		try {
			
			//check map contain the employee id or not if yes then remove from the map.
			if(!map.containsKey(empId)) {
				throw new Exception("Enter correct employee id");
			}
			else {
				
				map.remove(empId);
				System.out.println("Deleted sucessfully :) ");
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	
	}
}
