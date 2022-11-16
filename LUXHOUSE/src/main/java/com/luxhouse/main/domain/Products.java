package com.luxhouse.main.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "products")
public class Products implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="product_code",columnDefinition = "nvarchar(50) not null")
    private String productCode;
    
    @Column(name="product_name",columnDefinition = "nvarchar(100) not null")
    private String productName;
    
    @Column(columnDefinition = "nvarchar(500) not null")
    private String image;
    
    @Column(columnDefinition = "Decimal(18,4) NOT NULL default '0.0000'")
    private Double price;
    
    @Column(columnDefinition = "nvarchar(4000) null")
    private String discription;
    
    @Column(columnDefinition = "int Default 1 null")
    private Integer quantity;
    
    private Boolean discontinued;
    
    private Boolean is_featured;
    
    private Boolean is_new;
    
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name = "category_product_id")
    private CategoryProducts categoryProducts;
    
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Suppliers suppliers;
    
    @Temporal(TemporalType.DATE)
    private Date created_at = new Date();
    
    @Temporal(TemporalType.DATE)
    private Date updated_at = new Date();
    
    @JsonIgnore
    @OneToMany(mappedBy = "products")
    private List<ProductImages> productImagesds;
    
    @JsonIgnore
    @OneToMany(mappedBy = "products")
    private List<ProductReviews> productReviews;
    
    @JsonIgnore
    @OneToMany(mappedBy = "products")
    private List<CartUsers> cartUsers;
}
