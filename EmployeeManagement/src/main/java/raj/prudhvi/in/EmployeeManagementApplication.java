package raj.prudhvi.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import raj.prudhvi.in.model.Employee;
import raj.prudhvi.in.service.EmployeeServiceImpl;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner{
	
	@Autowired
	EmployeeServiceImpl emp1;
	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setEname("aman");
		emp.setEcity("lko");
		emp.setEsalary(20.5f);
		
		emp1.saveEmployee(emp);
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
