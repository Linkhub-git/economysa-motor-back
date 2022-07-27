package com.economysa.motor.app.core.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {


  private ProductRequest product;
  
  private ProviderRequest provider;
  
  private BrandRequest brand;
  
  private CategoryRequest category;
  
}
