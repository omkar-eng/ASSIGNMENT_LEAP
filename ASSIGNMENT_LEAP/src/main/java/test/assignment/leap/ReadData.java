package test.assignment.leap;

import java.util.Map;


//class for read the data.
public class ReadData {
	
	//function for read the data.
	public void read(String empId, Map<String,Employee> map) {
		
		try {
			
			//check employee id present or not in map if yes then read the data.
			if(!map.containsKey(empId)) {
				throw new Exception("Enter correct employee id");
			}
			else {
				System.out.println(map.get(empId).toString());
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
