package com.crm.crud.employees.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.crud.employees.entity.Employee;

import jakarta.persistence.EntityManager;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll(){
        return entityManager.createQuery("FROM Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id){
        return entityManager.find(Employee.class, id);
    }


    @Override
    public Employee createOrUpdate(Employee employee){
        return entityManager.merge(employee);
    }

    @Override
    public void delete(int id){
        Employee employee =  entityManager.find(Employee.class, id);
        entityManager.remove(employee); 
    }
}
