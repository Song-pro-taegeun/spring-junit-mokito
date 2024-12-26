package com.songpro.spring_junit_mokito_back.service;

import com.songpro.spring_junit_mokito_back.entity.User;
import com.songpro.spring_junit_mokito_back.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUserList(){
        return userRepository.getUsers();
    }
}
