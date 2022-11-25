package com.luxhouse.main.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50) not null")
    private String username;

    @Column(columnDefinition = "varchar(MAX) not null")
    private String password;

    @Column(columnDefinition = "nvarchar(100) not null")
    private String fullname;

    private Boolean gender;

    @Column(columnDefinition = "nvarchar(100) not null")
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "file_path_img",columnDefinition = "varchar(MAX) null")
    private String filePath;
    
    @Column(columnDefinition = "nvarchar(500) null")
    private String avartar;

    @Column(name = "type_img",columnDefinition = "varchar(50) null")
    private String typeImg;
    
    @Column(columnDefinition = "varchar(15) not null")
    private String phone;

    @Column(columnDefinition = "nvarchar(500) null")
    private String address;

    private Boolean status;

    @Temporal(TemporalType.DATE)
    private Date created_at = new Date();

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Roles> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Authorities> authorities;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<ProductReviews> productReviews;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Orders> orders;
    
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<CartUsers> cartUsers;
}
