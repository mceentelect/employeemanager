package tech.springangularincubator.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.springangularincubator.employeemanager.exception.EmployeeNotFoundException;
import tech.springangularincubator.employeemanager.model.Employee;
import tech.springangularincubator.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());

        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee with id: " + id + " does not exist")
        );
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
