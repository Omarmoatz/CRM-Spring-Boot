package com.crm.crud.leads.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "leads")
public class Lead {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
                           CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
        name = "lead_products",
        joinColumns = @JoinColumn(name = "lead_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Lead(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // add convenience method
    public void addProduct(Product product){

        if(products == null){
            products = new ArrayList<>();
        }

        products.add(product);
        product.addLead(this);
    }

    
}
