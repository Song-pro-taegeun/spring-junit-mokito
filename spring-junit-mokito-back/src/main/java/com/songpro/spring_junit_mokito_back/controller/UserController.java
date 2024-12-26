package com.songpro.spring_junit_mokito_back.controller;

import com.songpro.spring_junit_mokito_back.entity.User;
import com.songpro.spring_junit_mokito_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
