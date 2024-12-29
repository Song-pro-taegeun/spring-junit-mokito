package com.songpro.spring_junit_mokito_back.service;

import com.songpro.spring_junit_mokito_back.dto.UserDto;
import com.songpro.spring_junit_mokito_back.entity.User;
import com.songpro.spring_junit_mokito_back.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    public UserDto signIn(String userId, String userPwd){
        User user = userRepository.findByUserIdAndUserPwd(userId, userPwd);

        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());

        return userDto;
    }
}
