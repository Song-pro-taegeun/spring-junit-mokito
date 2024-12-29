package com.songpro.spring_junit_mokito_back.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.songpro.spring_junit_mokito_back.dto.UserDto;
import com.songpro.spring_junit_mokito_back.service.AuthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class) // 테스트할 컨트롤러 지정
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;    // 컨트롤러를 테스트하기 위한 모의 HTTP 클라이언트

    @MockBean
    private AuthService authService; // AuthService를 Mock으로 주입. 이를 통해 실제 AuthService 객체가 아닌 가짜 객체로 동작을 설정

    @Autowired
    private ObjectMapper objectMapper;  // Json <-> 객체 변환

    @Test
    @DisplayName("signIn 테스트")
    void signIn() throws Exception {
        // Mock 데이터 준비
        // 리턴 값 셋팅
        // 1. Given 준비 단계
        UserDto mockUser = new UserDto();
        mockUser.setUserId("test");
        mockUser.setUserName("테스트유저");

        // Mock 서비스 동작 설정
        // Mock 객체의 특정 메서드 동작을 지정
        // anyString())로 요청이 오면, mockUser를 반환하도록 설정
        Mockito.when(authService.signIn(anyString(), anyString()))
                .thenReturn(mockUser);

        // 2. When 실행 단계
        // API 호출
        final ResultActions resultActions = mockMvc.perform(get("/auth/signIn")
                        .param("userId", "test")
                        .param("userPwd", "testPwd")
                        .contentType(MediaType.APPLICATION_JSON));


        // 3. then 검증 단계
        resultActions
                .andExpect(status().isOk())
                // 응답 본문이 mockUser 객체의 JSON 표현과 일치하는지 검증. ObjectMapper를 사용하여 객체를 JSON으로 변환
                .andExpect(content().json(objectMapper.writeValueAsString(mockUser)))
                .andDo(result -> System.out.println("Response: " + result.getResponse().getContentAsString()));

    }
}