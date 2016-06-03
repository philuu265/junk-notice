package com.lovediary.service;

import com.lovediary.model.User;

/**
 * Created by philu on 6/3/2016.
 */
public interface UserService {
    User save(User user);

    User find(String email);
}
