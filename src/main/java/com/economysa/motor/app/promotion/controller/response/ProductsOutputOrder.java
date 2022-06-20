package com.economysa.motor.app.promotion.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsOutputOrder {

    private Long id;

    private Long productId;

    private String productName;

    private Double priceUnit;

    private Double productUomQty;

    private Integer taxId;

    private String taxName;

    private Boolean isRewardLine;
}
