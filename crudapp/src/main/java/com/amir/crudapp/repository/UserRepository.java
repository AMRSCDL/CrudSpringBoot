package com.amir.crudapp.repository;

import com.amir.crudapp.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
