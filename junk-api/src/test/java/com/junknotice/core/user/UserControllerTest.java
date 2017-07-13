package com.junknotice.core.user;

import com.junknotice.user.RegisterUser;
import com.junknotice.user.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Phi Luu.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController controller;

    @Before
    public void setUp() throws Exception {
        controller = new UserController(userService);
    }

    @Test
    public void register() throws Exception {
        RegisterUser user = new RegisterUser();
        controller.register(user);
        verify(userService, Mockito.times(1)).save(user.toUserEntity());
    }

    @Test
    public void getAll() throws Exception {
        User user = new User();
        user.setUsername("philuu265");
        User user1 = new User();
        user1.setUsername("philuu");
        List<User> users = Arrays.asList(user,user1);
        when(userService.findAll()).thenReturn(users);
        assertThat(controller.getAll(), equalTo(users));
    }
}