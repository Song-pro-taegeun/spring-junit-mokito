package test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll  // 테스트 시작 전 실행하는 메서드를 표현(static)
    public static void beforeAll(){
        System.out.println("Before All");
        System.out.println();
    }

    @AfterAll    // 테스트 종료 후 실행하는 메서드를 표현(static)
    public static void afterAll(){
        System.out.println("After All");
        System.out.println();
    }

    @BeforeEach  // 각 테스트 메서드 시작 전 실행하는 메서드를 표현
    public void beforeEach(){
        System.out.println("Before Each");
        System.out.println();
    }

    @AfterEach  // 각 테스트 메서드 시작된 후 실행하는 메서드를 표현
    public void afterEach(){
        System.out.println("After Each");
        System.out.println();
    }

    @Test   // 테스트용 메소드를 표현하는 어노테이션
    public void test1(){
        System.out.println("test1");
        System.out.println();
    }

    @Test
    @DisplayName("Test2 Case")
    public void test2(){
        System.out.println("Test2");
        System.out.println();
    }

    @Test
    @Disabled   // 테스트를 실행하지 않는 어노테이션
    public void test3(){
        System.out.println("Test3");
        System.out.println();
    }
}
