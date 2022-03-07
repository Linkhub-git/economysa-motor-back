package com.economysa.motor.app.configuration.repository;

import com.economysa.motor.app.configuration.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Long> {

  @Query("select b from Brand b where b.parent.name = :name or b.name = :name order by b.name asc")
  Page<Brand> findByParentOrName(@Param("name") String name, Pageable pageable);

  @Query("select b from Brand b order by b.name asc")
  Page<Brand> find(Pageable pageable);

  @Query("select b from Brand b where b.parent is null and b.name = :name")
  List<Brand> findParent(@Param("name") String name);

  @Query("select b from Brand b where b.parent.id = :parentId and b.name = :name")
  Brand findChildByName(@Param("parentId") Long parentId, @Param("name") String name);

  @Query("select b from Brand b where b.parent is not null and b.name = :name")
  List<Brand> findByNameAndParentNotNull(@Param("name") String name);
}
