package raj.prudhvi.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import raj.prudhvi.in.model.Employee;
import raj.prudhvi.in.service.IEmployeeService;

@RestController
@RequestMapping(value = "/ems")
public class EmployeeController {

	@Autowired
	private IEmployeeService eservice;

	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
		Integer eid = eservice.saveEmployee(emp);
		return new ResponseEntity<String>("Employee With ID :" + eid + " created Successfully", HttpStatus.CREATED);
	}

	
	@GetMapping(value="/getEmployee/{eid}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable Integer eid)
	{
		Employee emp=eservice.getEmployeeById(eid);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/delete/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer eid)
	{
		eservice.deleteEmployee(eid);
		return new ResponseEntity<String>("Employee With ID :" + eid + " Deleted Successfully", HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> employees=eservice.getAllEmployes();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateEmployee/{eid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer eid,@RequestBody Employee emp)
	{
		Employee employee=eservice.getEmployeeById(eid);
		employee.setEcity(emp.getEcity());
		employee.setEsalary(emp.getEsalary());
		eservice.saveEmployee(employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	
}
