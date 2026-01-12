package com.github.aguinaldoNetoDev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Order(6)
class SimpleMathSectionThreeTest {

    SimpleMath math;

    @BeforeEach
    void beforeEach() {
         math = new SimpleMath();
    }

    /*
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameters") // recebe o nome do método que contém os parâmetros
    //@MethodSource()
    @CsvSource()
    void testDivision_when_sixDotTwoDividedTwoDtoZero_shouldReturnThreeDotOne(double firstValue, double secondValue, double expected) {
        //GIVEN & WHEN
        Double result = math.division(firstValue, secondValue);

        assertEquals(expected, result, 2D, //2D é um delta que vai olhar somente para 2 casas decimais.
                () -> firstValue + " + " + secondValue + " did not produce " + expected);
    }

    //public static Stream<Arguments> testDivisionInputParameters() {

    public static Stream<Arguments> testDivision_when_sixDotTwoDividedTwoDtoZero_shouldReturnThreeDotOne() {
    return Stream.of(
            Arguments.of(6.2D, 2D, 3.1D),
            Arguments.of(71D, 14D, 5.07D),
            Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }


    // TESTANDO PARA CSV
    @ParameterizedTest
    @CsvSource({
            "6.2, 2, 3.1",
            "71, 14, 5.07",
            "18.3, 3.1, 5.90"
    })
    void testDivision_when_sixDotTwoDividedTwoDtoZero_shouldReturnThreeDotOne(double firstValue, double secondValue, double expected) {
        //GIVEN & WHEN
        Double result = math.division(firstValue, secondValue);

        assertEquals(expected, result, 2D,
                () -> firstValue + " + " + secondValue + " did not produce " + expected);
    }


    // TESTANDO COM ARQUIVO CSV
    @ParameterizedTest
    @CsvFileSource(resources = "/testDivision_when_sixDotTwoDividedTwoDtoZero_shouldReturnThreeDotOne.csv")
    void testDivision_when_sixDotTwoDividedTwoDtoZero_shouldReturnThreeDotOne(double firstValue, double secondValue, double expected) {
        //GIVEN & WHEN
        Double result = math.division(firstValue, secondValue);

        assertEquals(expected, result, 2D,
                () -> firstValue + " + " + secondValue + " did not produce " + expected);
    }
     */

    // TESTANDO COM VALUE SOURCE

    @ParameterizedTest
    @ValueSource(strings = {"Pelé", "Senna", "Keith Moon"})
    void testValueSource(String names) {
        System.out.println(names);

        Assertions.assertNotNull(names);
    }

}