package com.luxhouse.main.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prduct_reviews")
public class ProductReviews implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    
    @Column(columnDefinition="float not null")
    private Double rating;
    
    @Column(columnDefinition="nvarchar(500) not null")
    private String comment;

    @Temporal(TemporalType.DATE)
    private Date created_at;
    
    @Temporal(TemporalType.DATE)
    private Date updated_at;
}
