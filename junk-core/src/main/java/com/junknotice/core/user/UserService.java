package com.junknotice.core.user;

import java.util.List;

/**
 * Created by philu on 6/23/2016.
 */
public interface UserService {
    User save(User user);

    User find(String email);

    List<User> findAll();
}
