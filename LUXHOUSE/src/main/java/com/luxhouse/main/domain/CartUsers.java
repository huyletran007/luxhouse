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
@Table(name = "cart_product_users")
public class CartUsers implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="quantity",columnDefinition="Decimal(18,4) default '0.0000'")
    private Double quantity;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;
    
    @Temporal(TemporalType.DATE)
    private Date created_at = new Date();
    
    @Temporal(TemporalType.DATE)
    private Date updated_at = new Date();
}
