package com.ashburn.postgresbase.repository;

import com.ashburn.postgresbase.model.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {
}
