package com.example.hw_2_5.service;

import com.example.hw_2_5.exception.EmployeeAlreadyAddedException;
import com.example.hw_2_5.exception.EmployeeNotFoundException;
import com.example.hw_2_5.exception.EmployeeStorageIsFullException;
import com.example.hw_2_5.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final int SIZE = 5;
    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employee.contains(employees)) {
            employees.remove(employee);
            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employees)) {
            return employee;
        }
        throw new EmployeeNotFoundException();

    }
    public list<Employee> findAll() {
        return new ArrayList<>(employees);
    }
}

