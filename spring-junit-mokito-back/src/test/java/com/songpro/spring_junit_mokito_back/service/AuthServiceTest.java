package com.songpro.spring_junit_mokito_back.service;

import com.songpro.spring_junit_mokito_back.dto.ReqUserDto;
import com.songpro.spring_junit_mokito_back.dto.UserDto;
import com.songpro.spring_junit_mokito_back.entity.User;
import com.songpro.spring_junit_mokito_back.repository.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Mockito 활용 테스트 클래스 확장
@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    // 테스트 대상 클래스에 의존성 주입
    @InjectMocks
    private AuthService authService;

    // Mock으로 설정하여 실제 동작이 아닌 가짜 동작을 테스트
    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    @DisplayName("로그인 테스트")
    void signIn() {
    }

    @Test
    @DisplayName("회원가입 테스트")
    void signUp() {
        // Given: 테스트를 위한 입력 데이터와 예상 동작 정의
        // 회원가입 요청 객체 생성
        ReqUserDto reqUserDto = new ReqUserDto();
        reqUserDto.setUserId("songPro");
        reqUserDto.setUserName("pro");
        reqUserDto.setUserPwd("test");

        // 데이터베이스 엔티티 객체 생성
        User user = new User();
        user.setUserId("songPro");
        user.setUserName("pro");
        user.setUserPwd("test");

        // 응답으로 반환될 DTO 생성
        UserDto userDto = new UserDto();
        userDto.setUserId("songPro");
        userDto.setUserName("pro");

        // Mocking behavior : 의존성 주입된 객체의 동작을 모킹
        when(modelMapper.map(reqUserDto, User.class))   // 요청 DTO를 User 엔티티로 매핑
                .thenReturn(user);  // 매핑 결과로 user 반환
        when(userRepository.save(user)) // user 엔티티를 저장
                .thenReturn(user);  // 저장된 엔티티를 반환
        when(modelMapper.map(user, UserDto.class))  // 저장된 엔티티를 응답 DTO로 매핑
                .thenReturn(userDto);   // 매핑 결과로 userDto 반환

        // When:  실제로 테스트할 메서드
        UserDto result = authService.signUp(reqUserDto);

        // Then: 결과 검증
        assertNotNull(result, "회원가입 결과가 null");  // 결과가 null이 아닌지 확인
        assertEquals(reqUserDto.getUserId(), result.getUserId(), "ID 불일치");
        assertEquals(reqUserDto.getUserName(), result.getUserName(), "Name 불일치");

        // Mock 객체 호출 여부 검증
        verify(modelMapper).map(reqUserDto, User.class);    // 요청 DTO에서 User로 매핑이 호출되었는지 확인
        verify(userRepository).save(user);  // user 엔티티 저장이 호출되었는지 확인
        verify(modelMapper).map(user, UserDto.class);   // 저장된 엔티티를 응답 DTO로 매핑이 호출되었는지 확인
    }
}