package com.crm.crud.employees.model;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;



@Entity
@Data
@NoArgsConstructor
@Table(name = "employee_profile")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_num")
    private String phoneNum;

    public EmployeeProfile(String jobTitle, String address, String phoneNum) {
        this.jobTitle = jobTitle;
        this.address = address;
        this.phoneNum = phoneNum;
    }

}
