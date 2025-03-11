package com.crm.crud.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crm.crud.users.models.Authority;


@RepositoryRestResource(path = "authorities")
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    
}
