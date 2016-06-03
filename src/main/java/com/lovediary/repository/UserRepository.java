package com.lovediary.repository;

import com.lovediary.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by philu on 6/2/2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User save(User user);

    User findByEmail(String email);
}
