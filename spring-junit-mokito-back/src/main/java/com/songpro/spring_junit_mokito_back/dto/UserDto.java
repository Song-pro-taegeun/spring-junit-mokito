package com.songpro.spring_junit_mokito_back.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String userName;

    @QueryProjection
    public UserDto(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
