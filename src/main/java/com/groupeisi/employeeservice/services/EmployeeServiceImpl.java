package com.groupeisi.employeeservice.services;

import com.groupeisi.employeeservice.entities.Employee;
import com.groupeisi.employeeservice.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(int id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee newEmployee = existingEmployee.get();
            newEmployee.setFirstName(employee.getFirstName());
            newEmployee.setLastName(employee.getLastName());
            newEmployee.setEmailId(employee.getEmailId());
            newEmployee.setPhoneNumber(employee.getPhoneNumber());
            return employeeRepository.save(newEmployee);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
