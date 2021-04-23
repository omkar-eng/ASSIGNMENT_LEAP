package test.assignment.leap;

// POJO class of employee.
public class Employee {
	
	//variable of employee class.
	private String empName;
	private String empSalary;
	
	//Getter and Setter.
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [" + getEmpName() + ", " + getEmpSalary() + "]";
	}
	
	

}
