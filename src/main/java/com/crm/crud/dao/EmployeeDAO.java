package com.crm.crud.dao;

import java.util.List;

import com.crm.crud.entity.Employee;


public interface EmployeeDAO {
    
    List<Employee> findAll();
}
