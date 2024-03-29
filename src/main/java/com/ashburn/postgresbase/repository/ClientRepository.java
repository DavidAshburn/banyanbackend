package com.ashburn.postgresbase.repository;

import com.ashburn.postgresbase.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
