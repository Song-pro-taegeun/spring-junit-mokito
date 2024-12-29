package com.songpro.spring_junit_mokito_back.controller;

import com.songpro.spring_junit_mokito_back.dto.UserDto;
import com.songpro.spring_junit_mokito_back.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/signIn")
    public UserDto signIn(@RequestParam String userId, @RequestParam String userPwd) {
        return authService.signIn(userId, userPwd);
    }
}
