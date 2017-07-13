package com.junknotice.core.validation;

import com.junknotice.core.user.UserService;
import com.junknotice.core.validation.annotation.Username;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Phi Luu
 * @since 7/13/2017.
 */
public class UsernameConstraintValidator implements ConstraintValidator<Username, String> {

    private UserService userService;

    @Override
    public void initialize(Username constraintAnnotation) {
        // nothing to do
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userService.existsUsername(username)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("User " + username + " already exists!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
