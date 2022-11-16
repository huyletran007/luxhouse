package com.luxhouse.main.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Suppliers implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="supplier_code",columnDefinition = "nvarchar(50) not null")
    private String supplierCode;
    
    @Column(name="supplier_name",columnDefinition = "nvarchar(100) not null")
    private String supplierName;
    
    @Column(columnDefinition = "nvarchar(2000) null")
    private String decription;
    
    @Column(columnDefinition = "nvarchar(500) null")
    private String image;
    
    @Temporal(TemporalType.DATE)
    private Date created_at = new Date();

    @Temporal(TemporalType.DATE)
    private Date updated_at = new Date();
    
    @JsonIgnore
    @OneToMany(mappedBy = "suppliers")
    private List<Products> products;
}
