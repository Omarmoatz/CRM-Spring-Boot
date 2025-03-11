package com.crm.crud.employees.service;

import java.util.List;

import com.crm.crud.employees.model.Employee;


public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee createOrUpdate(Employee employee);

    void delete(int id);
}