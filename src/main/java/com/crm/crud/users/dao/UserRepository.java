package com.crm.crud.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crm.crud.users.models.User;



@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, String> {
    
}
