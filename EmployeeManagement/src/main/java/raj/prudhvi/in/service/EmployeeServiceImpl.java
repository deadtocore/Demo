package raj.prudhvi.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raj.prudhvi.in.dao.EmployeeDAO;
import raj.prudhvi.in.exception.EmployeeNotFoundException;
import raj.prudhvi.in.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeDAO edao;
	
	public Integer saveEmployee(Employee employee) {
		Employee emp=edao.save(employee);
		Integer eid=emp.getEid();
		return eid;
	}
	
	
	@Override
	public Employee getEmployeeById(Integer eid) {
		Optional<Employee> optional=edao.findById(eid);
		Employee emp=optional.orElseThrow(()->new EmployeeNotFoundException("Employee Not Exists"));
		return emp;
	}
	
	@Override
	public void deleteEmployee(Integer eid) {
		Employee emp=getEmployeeById(eid);
		edao.delete(emp);
		
	}
	
	
	@Override
	public List<Employee> getAllEmployes() {
		List<Employee> employees=edao.findAll();
		return employees;
	}
	
}
