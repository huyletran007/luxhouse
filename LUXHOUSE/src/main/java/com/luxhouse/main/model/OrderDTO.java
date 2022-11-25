package com.luxhouse.main.model;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
    private Long userId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipDistrict;
    private String shipPhuong;
    private String shipFee;
    private Date shipped_date;
    private Integer paymentTypeId;
}
