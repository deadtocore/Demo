package raj.prudhvi.in.service;

import java.util.List;

import raj.prudhvi.in.model.Employee;

public interface IEmployeeService {

	// 1.Save Employee
	public Integer saveEmployee(Employee employee);

	// 2.Get One Employee Based On Employee ID
	public Employee getEmployeeById(Integer eid);

	// 3.Delete Employee
    public void deleteEmployee(Integer eid);

    // 4.Get All Employees
    public List<Employee> getAllEmployes();

}
