package com.junknotice.user;

import com.junknotice.core.user.User;
import com.junknotice.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by philu on 6/4/2016.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody RegisterUser userDto) {
        User user = userDto.toUserEntity();
        return ResponseEntity.ok(service.save(user));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        return service.findAll();
    }
}
