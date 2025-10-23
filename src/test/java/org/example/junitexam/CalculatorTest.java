package org.example.junitexam;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   // @Order 어노테이션 순서에 따라 테스트를 진행하려면 추가 필요 (OrderAnnotation)
public class CalculatorTest {
    Calculator calculator = null;

    @BeforeAll
    static void beforeAll() {
        System.out.println("테스트가 실행되기 전 한 번만 실행 - 전체적인 세팅 등을 할 수 있음");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("전체 테스트가 종료될 때 한 번만 실행 - 마무리 작업 진행");
    }

    @BeforeEach // 테스트 전에 실행되도록 하는 어노테이션
    public void setup() {
        calculator = new Calculator();
        System.out.println("테스트 실행 전");
    }

    @AfterEach // 테스트 후에 실행되도록 하는 어노테이션
    public void teardown() {
        System.out.println("테스트 실행 후");
    }


    @Test
    @Order(2)
    void add() {
        System.out.println("add 테스트 실행");
        int result = calculator.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    @Order(4)
    void subtract() {
        System.out.println("subtract 테스트 실행");
        int result = calculator.subtract(5, 2);
        assertEquals(3, result);
    }

    @Test
    @Order(3)
    void multiply() {
        System.out.println("multiply 테스트 실행");
        int result = calculator.multiply(5, 2);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("나누기 테스트") // 실행 창 왼쪽에 메소드명 대신 보이게 할 내용 지정 가능
    @Order(1)
    void divide() {
        System.out.println("divide 테스트 실행");
        assertEquals(5, calculator.divide(10, 2));
        assertEquals(4, calculator.divide(36, 9));
        assertEquals(3, calculator.divide(3, 1));
        assertEquals(12, calculator.divide(144, 12));
    }


}
