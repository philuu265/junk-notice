package com.junknotice.core.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by philu on 6/23/2016.
 */
@Entity
public class User {
    private String username;
    private String email;
    private String displayName;
    private String pwd_hash;

    @Column
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Column
    public String getPwd_hash() {
        return pwd_hash;
    }

    public void setPwd_hash(String pwd_hash) {
        this.pwd_hash = pwd_hash;
    }
}
