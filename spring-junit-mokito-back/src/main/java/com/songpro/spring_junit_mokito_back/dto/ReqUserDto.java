package com.songpro.spring_junit_mokito_back.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReqUserDto {
    private String userId;
    private String userName;
    private String userPwd;
}
