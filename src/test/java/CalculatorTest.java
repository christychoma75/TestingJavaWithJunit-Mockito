import com.appdevs.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {
    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @beforeAll Method.");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @afterAll method.");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach Test method.");
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing @AfterEach test method.");
    }

    @DisplayName("Test 20/5 = 2")
    @Test
    void testIntegerDivision_WhenTenIsDividedByFive_ShouldReturnTwo() {
        int result = calculator.integerDivision(10, 5);

        assertEquals(2, result);
    }

    //@Disabled("Still need to work on it.")
    @DisplayName("Test divided by zero.")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        String expectedExceptionMessage = "/ by zero";
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(5, 0);
        }, "division by zero should have thrown an Arithmetic exception.");

        assertEquals(expectedExceptionMessage, actualException.getMessage(),"Unexpected exception message");
    }

    @DisplayName("Test 31-30 = 1")
    @Test
    void testIntegerSubtraction_WhenThrityOneMinusThirty_ShouldReturnOne() {
        int result = calculator.integerSubtraction(31, 30);

        assertEquals(1, result);
    }
}