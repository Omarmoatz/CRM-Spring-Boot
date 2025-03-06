package com.crm.crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.crud.dao.EmployeeDAO;




@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }


    @GetMapping("/employees")
    public void getEmployees(){
        employeeDAO.findAll();
    }

}
