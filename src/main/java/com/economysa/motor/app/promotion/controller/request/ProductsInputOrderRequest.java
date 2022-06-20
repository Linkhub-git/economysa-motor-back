package com.economysa.motor.app.promotion.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsInputOrderRequest {

    private Long productId;

    private Double priceUnit;

    private Integer productUomQty;

    private Integer taxId;

}
