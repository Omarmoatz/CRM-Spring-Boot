package com.crm.crud.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crm.crud.employees.model.EmployeeProfile;


@RepositoryRestResource
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Integer>{
}
