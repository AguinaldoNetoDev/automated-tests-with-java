package com.github.aguinaldoNetoDev;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SimpleMathTest {

    SimpleMath math;
    Double firstValue;
    Double secondValue;

    @BeforeAll
    static void setup() {
        System.out.println("Before All");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("After All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
         math = new SimpleMath();

        firstValue = 6.2D;
        secondValue = 2D;
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
        math = new SimpleMath();
    }


    @Test
    void testSum_when_sixDotTwoAddTwoDtoZero_shouldReturnEightDotTwo() {
        // GIVEN
        Double expectedResult = 8.2D;

        // WHEN
        Double result = math.sum(firstValue, secondValue);

        // THEN
        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testSubtraction_when_sixDotTwoSubtractTwoDtoZero_shouldReturnFourDotTwo() {
        Double expectedResult = 4.2D;

        Double result = math.subtraction(firstValue, secondValue);

        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testMultiplication_when_sixDotTwoMultipliedTwoDtoZero_shouldReturnTwelveDotFour() {
        Double expectedResult = 12.4D;

        Double result = math.multiplication(firstValue, secondValue);

        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testDivision_when_sixDotTwoDividedTwoDtoZero_shouldReturnThreeDotOne() {
        Double expectedResult = 3.1D;

        Double result = math.division(firstValue, secondValue);

        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testMean_when_sixDotTwoAddTwoDtoZeroTheMean_shouldReturnFourDotOne() {
        Double expectedResult = 4.1D;

        Double result = math.mean(firstValue, secondValue);

        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testSquareRoot_when_squareRootForNine_shouldReturnThree() {
        Double expectedResult = 1.4142135623730951D;

        Double result = math.squareRoot(secondValue);

        assertEquals(expectedResult, result,
                () -> secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testDivision_when_firstNumberIsDividedByZero_shouldThrowArithmeticException() {

        String expectedMessage = "Impossible to divide by zero!";

        ArithmeticException result = assertThrows(ArithmeticException.class, () -> {
                math.division(firstValue, 0D);
        }, () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, result.getMessage(), () -> "Unexpected exception message!");
    }
}