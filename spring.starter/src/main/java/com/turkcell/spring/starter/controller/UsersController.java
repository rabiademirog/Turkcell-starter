package com.turkcell.spring.starter.controller;

import com.turkcell.spring.starter.dto.user.LoginDto;
import com.turkcell.spring.starter.entity.User;
import com.turkcell.spring.starter.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PostMapping("login")
    public String login(@RequestBody LoginDto loginDto) {
      return userService.login(loginDto);
    }


}
