package com.economysa.motor.app.configuration.repository;

import com.economysa.motor.app.configuration.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

  @Query("select c from Category c where c.parent.name = :name or c.name = :name order by c.name asc")
  Page<Category> findByParentOrName(@Param("name") String name, Pageable pageable);

  @Query("select c from Category c order by c.parent.name asc")
  Page<Category> find(Pageable pageable);

  @Query("select c from Category c where c.parent is null and c.name = :name")
  List<Category> findParent(@Param("name") String name);

  @Query("select c from Category c where c.parent.id = :parentId and c.name = :name")
  Category findChildByName(@Param("parentId") Long parentId, @Param("name") String name);

  @Query("select c from Category c where c.parent is not null and c.name = :name")
  List<Category> findByNameAndParentNotNull(@Param("name") String name);

  @Query("select c from Category c where c.id = :id")
  Optional<Category> findById(@Param("id") Long id);

  @Query("select c from Category c where c.parent is null order by c.name asc")
  List<Category> findParent();

  @Query("select c from Category c where c.parent.id = :parentId order by c.name asc")
  List<Category> findByParent(@Param("parentId") Long parentId);
}
