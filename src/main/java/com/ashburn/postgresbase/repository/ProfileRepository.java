package com.ashburn.postgresbase.repository;

import com.ashburn.postgresbase.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
