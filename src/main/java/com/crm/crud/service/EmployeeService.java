package com.crm.crud.service;

import java.util.List;

import com.crm.crud.entity.Employee;


public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee createOrUpdate(Employee employee);

    void delete(int id);
}