package com.junknotice.core.validation;

import com.junknotice.core.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author Phi Luu
 * @since 7/13/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UsernameConstraintValidatorTest {
    @Mock
    private UserService userService;

    @Mock
    private ConstraintValidatorContext validatorContext;

    @Mock
    private ConstraintValidatorContext.ConstraintViolationBuilder violationBuilder;

    private UsernameConstraintValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new UsernameConstraintValidator();
        validator.setUserService(userService);
    }

    @Test
    public void returnTrueWithValidUsername() throws Exception {
        String username = "administrator";
        when(userService.existsUsername(username)).thenReturn(false);
        assertTrue(validator.isValid(username, validatorContext));
    }

    @Test
    public void returnFalseWithExistUsername() throws Exception {
        String username = "administrator";
        when(userService.existsUsername(username)).thenReturn(true);
        when(validatorContext.buildConstraintViolationWithTemplate("User " + username + " already exists!")).thenReturn(violationBuilder);
        assertFalse(validator.isValid(username, validatorContext));
    }
}