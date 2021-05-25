package tech.springangularincubator.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.springangularincubator.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
