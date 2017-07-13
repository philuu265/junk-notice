package com.junknotice.core.validation;

/**
 * @author Phi Luu
 * @since 7/13/2017.
 */

import com.junknotice.core.user.UserService;
import com.junknotice.core.validation.annotation.Email;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<Email, String> {

    private UserService userService;

    @Override
    public void initialize(Email constraintAnnotation) {
        // nothing to do
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (userService.existsEmail(email)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Email " + email + " already exists!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
