package com.crm.crud.employees.dao;

import java.util.List;

import com.crm.crud.employees.model.Employee;


public interface EmployeeDAO {
    
    List<Employee> findAll();

    Employee findById(int id);

    Employee createOrUpdate(Employee employee);
    
    void delete(int id);
}
