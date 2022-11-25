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
@Table(name = "orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Temporal(TemporalType.DATE)
    private Date order_date = new Date();

    @Temporal(TemporalType.DATE)
    private Date shipped_date;

    @Column(name = "ship_name", columnDefinition = "nvarchar(50) not null")
    private String shipName;

    @Column(name = "ship_address", columnDefinition = "nvarchar(500) not null")
    private String shipAddress;

    @Column(name = "ship_city", columnDefinition = "nvarchar(150) not null")
    private String shipCity;

    @Column(name = "ship_district", columnDefinition = "nvarchar(150) not null")
    private String shipDistrict;
    
    @Column(name = "ship_phuong", columnDefinition = "nvarchar(150) not null")
    private String shipPhuong;

    @Column(name = "shipping_fee", columnDefinition = "decimal(18,4) not null")
    private Double shipFee;	
    
    @Column(name = "total_order", columnDefinition = "decimal(18,4) not null")
    private Double totalOrder; 
    
    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentTypes paymentTypes;
    
    @Temporal(TemporalType.DATE)
    private Date paid_date;
    
    @Column(name = "order_status", columnDefinition = "nvarchar(50) not null")
    private String orderStatus;
    
    @Temporal(TemporalType.DATE)
    private Date created_at = new Date();

    @Temporal(TemporalType.DATE)
    private Date updated_at;
    
    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<OrderDetails> orderDetails;
}
