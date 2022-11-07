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
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50) not null")
    private String username;

    @Column(columnDefinition = "varchar(50) not null")
    private String password;

    @Column(columnDefinition = "nvarchar(100) not null")
    private String fullname;

    private Boolean gender;

    @Column(columnDefinition = "nvarchar(100) not null")
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(columnDefinition = "nvarchar(500) null")
    private String avartar;

    @Column(columnDefinition = "varchar(15) not null")
    private String phone;

    @Column(columnDefinition = "nvarchar(500) null")
    private String address;

    private Boolean status;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;
    
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Authorities> authorities;
    
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<ProductReviews> productReviews;
    
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Orders> orders;
}
