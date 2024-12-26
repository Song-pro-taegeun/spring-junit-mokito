package com.songpro.spring_junit_mokito_back.service;

import com.songpro.spring_junit_mokito_back.dto.UserDto;
import com.songpro.spring_junit_mokito_back.entity.User;
import com.songpro.spring_junit_mokito_back.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUserList(){
        return userRepository.getUsers();
    }

    public List<String> getSimpleProjection(){
        return userRepository.getSimpleProjection();
    }

    public List<Map<String, Object>> getTupleProjection(){
        return userRepository.getTupleProjection();
    }

    public List<UserDto> getConstructorProjection(){
        return userRepository.getConstructorProjection();
    }

    public List<UserDto> getBeanProjection(){
        return userRepository.getBeanProjection();
    }

    public List<UserDto> getFieldProjection(){
        return userRepository.getFieldProjection();
    }

    public List<UserDto> getQueryProjection(){
        return userRepository.getQueryProjection();
    }
}
