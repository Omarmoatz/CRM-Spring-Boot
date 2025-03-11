package com.crm.crud.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.crud.employees.dao.EmployeeDAO;
import com.crm.crud.employees.dao.EmployeeRepository;
import com.crm.crud.employees.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee createOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id); 

        Employee theEmployee = null; 

        if (employee.isPresent()) {
            theEmployee = employee.get();
        }else{
            throw new RuntimeException("can't find employee with id " + id);
        }

        return theEmployee;
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    
    
}
