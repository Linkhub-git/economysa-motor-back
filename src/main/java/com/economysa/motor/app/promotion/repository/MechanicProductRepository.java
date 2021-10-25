package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MechanicProductRepository extends CrudRepository<MechanicProduct, Long> {

  @Query("select mp from MechanicProduct mp where mp.mechanic = :mechanicId")
  Page<MechanicProduct> findByMechanic(@Param("mechanicId") Long mechanicId, Pageable pageable);

  @Query("select mp from MechanicProduct mp where mp.mechanic = :mechanicId")
  List<MechanicProduct> findByMechanic(@Param("mechanicId") Long mechanicId);

  @Query("select mp from MechanicProduct mp where mp.mechanic = :mechanicId and mp.product.id = :productId")
  Optional<MechanicProduct> find(@Param("mechanicId") Long mechanicId, @Param("productId") Long productId);
}
