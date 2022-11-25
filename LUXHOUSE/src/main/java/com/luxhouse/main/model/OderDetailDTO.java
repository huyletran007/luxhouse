package com.luxhouse.main.model;

import lombok.Data;

@Data
public class OderDetailDTO {
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;
}
