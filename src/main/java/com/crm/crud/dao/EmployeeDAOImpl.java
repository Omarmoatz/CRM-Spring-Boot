package com.crm.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.crud.entity.Employee;

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

    // @Override
    // public Employee findById(int id){
    //     return entityManager.find(Employee.class, id);
    // }


    @Override
    public Employee createOrUpdate(Employee employee){
        return entityManager.merge(employee);
    }
}
