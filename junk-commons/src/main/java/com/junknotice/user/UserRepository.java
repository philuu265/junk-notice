package com.junknotice.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by philu on 6/23/2016.
 */
public interface UserRepository extends CrudRepository<User, String> {

    User save(User user);

    User findByEmail(String email);

    List<User> findAll();
}
