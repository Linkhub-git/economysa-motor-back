package com.economysa.motor.app.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.core.entity.Product;

public interface ProductRepository extends CrudRepository<Product, String>, JpaSpecificationExecutor<Product>  {

@Query("select p from Product p order by p.name asc")
Page<Product> findAll(Pageable pageable);

@Query("select p from Product p where p.id = :id")
Optional<Product> listByProductId(@Param("id") Long id);
  
@Query("select p from Product p where p.code = :code")
Optional<Product> listByProductCode(@Param("code") String code);
  
@Query("select p from Product p where p.name like %:name% order by p.name asc")
List<Product> listByProductName(@Param("name") String name);

@Query("select p from Product p where p.provider.id = :providerId")
List<Product> findByProviderId(@Param("providerId") Long providerId);

@Query("select p from Product p inner join p.provider where p.provider.code = :providerCode")
List<Product> findByProviderCode(@Param("providerCode") String providerCode);

@Query("select p from Product p inner join p.provider where p.provider.name like %:providerName%")
List<Product> findByProviderName(@Param("providerName") String providerName);

@Query("select p from Product p where p.brand.id = :brandId")
List<Product> findByBrandId(@Param("brandId") Long brandId);

@Query("select p from Product p inner join p.brand where p.brand.name like %:brandName%")
List<Product> findByBrandName(@Param("brandName") String brandName);

@Query("select p from Product p where p.category.id = :categoryId")
List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

@Query("select p from Product p inner join p.category where p.category.name like %:categoryName%")
List<Product> findByCategoryName(@Param("categoryName") String categoryName);

}