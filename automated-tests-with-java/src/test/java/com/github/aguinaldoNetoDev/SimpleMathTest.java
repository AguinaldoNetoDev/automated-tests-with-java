package com.github.aguinaldoNetoDev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SimpleMathTest {
    Double firstValue = 6.2D;
    Double secondValue = 2D;

    @Test
    void testSum_when_sixDotTwoAddTwoDtoZero_shouldReturnEightDotTwo() {
        // GIVEN
        SimpleMath math = new SimpleMath();
        Double expectedResult = 8.2D;

        // WHEN
        Double result = math.sum(firstValue, secondValue);

        // THEN
        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testSubtraction_when_sixDotTwoSubtractTwoDtoZero_shouldReturnFourDotTwo() {
        SimpleMath math = new SimpleMath();
        Double expectedResult = 4.2D;

        Double result = math.subtraction(firstValue, secondValue);

        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testMultiplication_when_sixDotTwoMultipliedTwoDtoZero_shouldReturnTwelveDotFour() {
        SimpleMath math = new SimpleMath();
        Double expectedResult = 12.4D;

        Double result = math.multiplication(firstValue, secondValue);

        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testDivision_when_sixDotTwoDividedTwoDtoZero_shouldReturnThreeDotOne() {
        SimpleMath math = new SimpleMath();
        Double expectedResult = 3.1D;

        Double result = math.division(firstValue, secondValue);

        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testMean_when_sixDotTwoAddTwoDtoZeroTheMean_shouldReturnFourDotOne() {
        SimpleMath math = new SimpleMath();
        Double expectedResult = 4.1D;

        Double result = math.mean(firstValue, secondValue);

        assertEquals(expectedResult, result,
                () -> firstValue + " + " + secondValue + " did not produce " + expectedResult);
    }

    @Test
    void testSquareRoot_when_squareRootForNine_shouldReturnThree() {
        SimpleMath math = new SimpleMath();
        Double squareRootValue = 9D;
        Double expectedResult = 3D;

        Double result = math.squareRoot(squareRootValue);

        assertEquals(expectedResult, result,
                () -> squareRootValue + " did not produce " + expectedResult);
    }
}