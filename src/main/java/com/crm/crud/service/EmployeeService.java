package com.crm.crud.service;

import java.util.List;

import com.crm.crud.entity.Employee;


public interface EmployeeService {

    List<Employee> findAll();
}