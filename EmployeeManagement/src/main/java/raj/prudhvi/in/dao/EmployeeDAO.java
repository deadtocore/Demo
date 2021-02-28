package raj.prudhvi.in.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import raj.prudhvi.in.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
