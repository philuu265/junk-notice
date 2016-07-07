package com.junknotice.user;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by philu on 6/23/2016.
 */
@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User find(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
