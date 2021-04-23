package test.assignment.leap;

import java.util.Map;

//Class for create data.
public class CreateData {
	
	public void create(String empId,String empName,String empSalary,Map<String,Employee> map,MapHandling mapHandling) {
		
		Employee employee=new Employee();
		Operations operations=new Operations();

		try {
			
			//check the size of employee id not exceed.
			if(empId.length() > 32)
				throw new Exception("The length of student id must be less than or equal to 32");
			
			//check the employee id already present or not.
			if(map.containsKey(empId))
				throw new Exception("Enter unique employee id");
			
			//set employee object.
			employee.setEmpName(empName);
			employee.setEmpSalary(empSalary);
			
			//sotre employee object and employee id object in a map.
			map.put(empId, employee);
			
			//check the size is not greater than 16KB.
			if (operations.jsonSize(employee)) {
				mapHandling.setMapHandling(map);
			} else {
				map.remove(empId);
				throw new Exception("Json value size exceeds 16KB");
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
