package com.crm.crud.dao;

import java.util.List;

import com.crm.crud.entity.Employee;


public interface EmployeeDAO {
    
    List<Employee> findAll();

    // Employee findById(int id);

    Employee createOrUpdate(Employee employee);
    
    // int delete();
}
