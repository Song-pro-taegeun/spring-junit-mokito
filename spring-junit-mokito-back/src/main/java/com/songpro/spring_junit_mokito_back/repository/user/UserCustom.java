package com.songpro.spring_junit_mokito_back.repository.user;

import com.songpro.spring_junit_mokito_back.dto.UserDto;
import com.songpro.spring_junit_mokito_back.entity.User;

import java.util.List;
import java.util.Map;

public interface UserCustom {
    List<User> getUsers();
    List<String> getSimpleProjection();
    List<Map<String, Object>> getTupleProjection();
    List<UserDto>  getConstructorProjection();
    List<UserDto> getBeanProjection();
    List<UserDto> getFieldProjection();
    List<UserDto> getQueryProjection();
}
