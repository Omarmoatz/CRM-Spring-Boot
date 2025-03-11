package com.crm.crud.employees.model;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_profile")
public class EmployeeProfile {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    private String hoopy;

    private String linkedInUrl;

}
