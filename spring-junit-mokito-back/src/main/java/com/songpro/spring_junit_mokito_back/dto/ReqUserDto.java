package com.songpro.spring_junit_mokito_back.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ReqUserDto {
    private String userId;
    private String userName;
    private String userPwd;
}
