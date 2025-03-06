package com.crm.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
       
}
