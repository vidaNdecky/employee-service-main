package com.groupeisi.employeeservice.controllers;

import com.groupeisi.employeeservice.entities.Employee;
import com.groupeisi.employeeservice.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok().body(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(employeeService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.create(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") int id, @RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
