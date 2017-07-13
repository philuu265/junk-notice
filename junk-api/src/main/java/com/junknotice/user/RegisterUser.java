package com.junknotice.user;

import com.junknotice.core.user.User;
import com.junknotice.core.validation.annotation.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by philu on 6/23/2016.
 */
public class RegisterUser {

    @NotEmpty
    @Length(min = 6, max = 30)
    @Getter @Setter private String username;

    @Email
    @Getter @Setter private String email;

    @NotEmpty
    @Length(min = 6, max = 30)
    @Getter @Setter private String displayName;

    @NotEmpty
    @Length(min = 6, max = 30)
    @Getter @Setter private String password;

    @NotEmpty
    @Length(min = 6, max = 30)
    @Getter @Setter private String confirmPassword;

    public User toUserEntity() {
        User user = new User();
        user.setDisplayName(this.displayName);
        user.setEmail(this.email);
        user.setUsername(this.username);
        user.setPwd_hash(this.password);
        return user;
    }
}
