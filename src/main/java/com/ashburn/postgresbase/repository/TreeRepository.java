package com.ashburn.postgresbase.repository;

import com.ashburn.postgresbase.model.Tree;
import org.springframework.data.repository.CrudRepository;

public interface TreeRepository extends CrudRepository<Tree, Long> {
}
