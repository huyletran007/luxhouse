package com.luxhouse.main.model;


import com.luxhouse.main.domain.PaymentTypes;
import com.luxhouse.main.domain.Users;

import lombok.Data;

@Data
public class OrderDTO {
    private Users userId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipDistrict;
    private String shipPhuong;
    private Double shipFee;
    private PaymentTypes paymentTypeId;
    private String orderStatus;
    
}
