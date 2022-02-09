package com.economysa.motor.app.configuration.repository;

import com.economysa.motor.app.configuration.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

  @Query("select c from Category c where c.parent.name = :name or c.name = :name order by c.name asc")
  Page<Category> findByParentOrName(@Param("name") String name, Pageable pageable);

  @Query("select c from Category c order by c.name asc")
  Page<Category> find(Pageable pageable);

  @Query("select c from Category c where c.parent is null and c.name = :name")
  List<Category> findParent(@Param("name") String name);

  @Query("select c from Category c where c.parent.id = :parentId and c.name = :name")
  Category findChildByName(@Param("parentId") Long parentId, @Param("name") String name);
}
