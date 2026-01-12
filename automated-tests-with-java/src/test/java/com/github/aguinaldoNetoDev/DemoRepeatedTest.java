package com.github.aguinaldoNetoDev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Order(2)
public class DemoRepeatedTest {

    SimpleMath math;
    Double firstValue;

    @BeforeEach
    void beforeEach() {
        math = new SimpleMath();

        firstValue = 6.2D;
    }


    @RepeatedTest(3)
    void testDivision_when_firstNumberIsDividedByZero_shouldThrowArithmeticException(RepetitionInfo repetitionInfo) {

        System.out.println("getCurrentRepetition: " + repetitionInfo.getCurrentRepetition() +
                " - getTotalRepetitions: " + repetitionInfo.getTotalRepetitions());

        String expectedMessage = "Impossible to divide by zero!";

        ArithmeticException result = assertThrows(ArithmeticException.class, () ->
                math.division(firstValue, 0D), "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, result.getMessage(), "Unexpected exception message!");
    }

}
