package com.junknotice.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Phi Luu.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    private UserService service;

    @Before
    public void setUp() throws Exception {
        service = new UserServiceImpl(repository);
    }

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setUsername("lnphi");
        service.save(user);
        verify(repository, Mockito.times(1)).save(user);
    }

    @Test
    public void find() throws Exception {
        User user = new User();
        user.setEmail("phi.luunhat@gmail.com");
        when(repository.findByEmail(user.getEmail())).thenReturn(user);
        assertThat(service.find(user.getEmail()), equalTo(user));
    }

    @Test
    public void findAll() throws Exception {
        User user = new User();
        user.setEmail("phi.luunhat@gmail.com");
        User user1 = new User();
        user1.setEmail("mon.bimbim@gmail.com");
        List<User> users = Arrays.asList(user, user1);
        when(repository.findAll()).thenReturn(users);
        assertThat(service.findAll(), equalTo(users));
    }

}