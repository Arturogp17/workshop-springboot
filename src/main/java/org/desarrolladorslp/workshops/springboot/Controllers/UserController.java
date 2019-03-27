package org.desarrolladorslp.workshops.springboot.Controllers;

import org.desarrolladorslp.workshops.springboot.models.User;
import org.desarrolladorslp.workshops.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public User user(@RequestParam(name = "email") String email, @RequestParam(name = "name") String name){
        return userService.CreateUser(email, name);
    }

    @GetMapping(value = "user/{id}")
    public User user (@PathVariable(value = "id") Long Id){
        return userService.findById(Id);
    }
}
