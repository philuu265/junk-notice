package com.lovediary.service;

import com.lovediary.model.User;
import com.lovediary.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by philu on 6/3/2016.
 */
public class UserServiceImplTest {

    private UserRepository repository;
    private UserServiceImpl service;

    @Before
    public void init() {
        repository = mock(UserRepository.class);
        service = new UserServiceImpl();
        service.setUserRepository(repository);
    }

    @Test
    public void save() throws Exception {
        User user = new User();
        service.save(user);

        verify(repository, times(1)).save(user);
    }

    @Test
    public void findByEmail() throws Exception {
        User user = new User();
        service.save(user);

        service.find(user.getEmail());

        verify(repository, times(1)).findByEmail(user.getEmail());
    }
}