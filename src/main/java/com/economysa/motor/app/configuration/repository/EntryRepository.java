package com.economysa.motor.app.configuration.repository;

import com.economysa.motor.app.configuration.entity.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EntryRepository extends CrudRepository<Entry, Long> {

  @Query("select e from Entry e where e.listPrice.id = :idListPrice order by e.code asc")
  List<Entry> findByListPrice(@Param("idListPrice") Long idListPrice);

  @Query("select e from Entry e where e.id = :id")
  Optional<Entry> findById(@Param("id") Long id);

  @Query("select e from Entry e where e.description like %:query% order by e.code asc")
  List<Entry> findByDescription(@Param("query") String query);
}
