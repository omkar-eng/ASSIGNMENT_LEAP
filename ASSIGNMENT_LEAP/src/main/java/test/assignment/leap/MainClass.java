package test.assignment.leap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//Main Class
public class MainClass {

	public static void main(String[] args) throws FileNotFoundException {
		
		Map<String,Employee> map=new HashMap<String,Employee>();
		Employee employee=new Employee();
		MapHandling mapHandling=new MapHandling();
		Operations operations=new Operations();
		
		//Ckeck file path present or not if not present then create new file.
		Scanner sc=new Scanner(System.in);
		String  path=null;
		try {
			
			System.out.print("Enter the path : ");
			path=sc.next();
			File file;
			
			if(path.isEmpty()) {
				
				file = new File("datastore.json");
				path = file.getAbsolutePath();
				System.out.println("File created with path :" + path);
				
			}
			else {
				path = path + File.separator + "dataStore.json";
				file = new File(path);
				file.getParentFile().mkdir();
				System.out.println("File created with path :" + path);
			}
			
			if(file.createNewFile()) {
				System.out.println("File created :"+file.getName());
			}
			else {
				map = operations.retrieveJson(path, mapHandling);
				mapHandling.setMapHandling(map);
			}
			
		}catch(Exception e) {
			System.err.println("An error occurred");
			e.printStackTrace();
		}
		
		//loop terminated when user enter 4th number for exit.
		while(true) {
			
			System.out.println("\n1 : Create \n2 : Read \n3 : Delete \n4 : exit");
			System.out.print("Please enter any number : ");
			int number=sc.nextInt();
			
			switch(number) {
			
			//Create Data.
			case 1:
				System.out.println("Enter employee id :");
				String empId=sc.next();
				System.out.println("Enter employee name :");
				String empName=sc.next();
				System.out.println("Enter employee salary :");
				String empSalary=sc.next();
				CreateData createData=new CreateData();
				createData.create(empId,empName,empSalary,map,mapHandling);
				break;
				
			//Read Data.
			case 2:
				System.out.println("Enter the employee id for read the data :");
				String empIdToRead=sc.next();
				ReadData readData=new ReadData();
				readData.read(empIdToRead,map);
				break;
				
			//Delete Data.
			case 3:
				System.out.println("Enter the employee id for delete the data :");
				String empIdToDelete=sc.next();
				DeleteData deleteData=new DeleteData();
				deleteData.delete(empIdToDelete,map);
				break;
				
			//Exit
			case 4:
				PrintWriter writer = new PrintWriter(path);
				writer.close();
				
				operations.create(path,mapHandling);
				System.exit(0);
				break;
			default :
				
				System.out.println("Enter correct number");
				break;
			
			}
			
		}
		
	}

}
