package com.groupeisi.employeeservice.services;

import com.groupeisi.employeeservice.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(int id);

    Employee create(Employee employee);

    Employee update(int id, Employee employee);

    void delete(int id);
}
