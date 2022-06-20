package com.economysa.motor.app.promotion.controller.response;

import com.economysa.motor.app.promotion.controller.request.ProductsInputOrderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputOrder {

    private Long orderId;

    private List<ProductsOutputOrder> products;
}
