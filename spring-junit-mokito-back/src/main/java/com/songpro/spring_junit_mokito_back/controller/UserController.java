package com.songpro.spring_junit_mokito_back.controller;

import com.songpro.spring_junit_mokito_back.dto.UserDto;
import com.songpro.spring_junit_mokito_back.entity.User;
import com.songpro.spring_junit_mokito_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/simpleProjection")
    public List<String> getSimpleProjection(){
        return userService.getSimpleProjection();
    }

    @GetMapping("/tupleProjection")
    public List<Map<String, Object>> getTupleProjection(){
        return userService.getTupleProjection();
    }

    // @AllArgsConstructor 필요 -> QueryProjection으로 모든 생성자 생성시 해당 어노테이션 불필요
    @GetMapping("/constructorProjection")
    public List<UserDto> getConstructorProjection(){
        return userService.getConstructorProjection();
    }

    // @NoArgsConstructor 필요
    @GetMapping("/beanProjection")
    public List<UserDto> getBeanProjection(){
        return userService.getBeanProjection();
    }

    @GetMapping("/fieldProjection")
    public List<UserDto> getFieldProjection(){
        return userService.getFieldProjection();
    }

    @GetMapping("/queryProjection")
    public List<UserDto> getQueryProjection(){
        return userService.getQueryProjection();
    }


}
