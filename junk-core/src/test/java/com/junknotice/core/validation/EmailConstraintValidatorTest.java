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
public class EmailConstraintValidatorTest {
    @Mock
    private UserService userService;

    @Mock
    private ConstraintValidatorContext validatorContext;

    @Mock
    private ConstraintValidatorContext.ConstraintViolationBuilder violationBuilder;

    private EmailConstraintValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new EmailConstraintValidator();
        validator.setUserService(userService);
    }

    @Test
    public void returnTrueWithValidEmail() throws Exception {
        String email = "hello@kpi.org";
        when(userService.existsEmail(email)).thenReturn(false);
        assertTrue(validator.isValid(email, validatorContext));
    }

    @Test
    public void returnFalseWithExistEmail() throws Exception {
        String email = "hello@kpi.org";
        when(userService.existsEmail(email)).thenReturn(true);
        when(validatorContext.buildConstraintViolationWithTemplate("Email " + email + " already exists!")).thenReturn(violationBuilder);
        assertFalse(validator.isValid(email, validatorContext));
    }
}