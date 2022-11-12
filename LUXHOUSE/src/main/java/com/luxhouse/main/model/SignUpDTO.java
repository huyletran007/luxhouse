package com.luxhouse.main.model;

import lombok.Data;

@Data
public class SignUpDTO {
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String phone;
}
