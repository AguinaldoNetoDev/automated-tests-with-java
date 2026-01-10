package com.github.aguinaldoNetoDev;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraysCompareTest {

    @Test
    void testSort() {
        int[] numbers = { 25, 8, 21, 32, 3 };
        int[] expectedArray =  { 3, 8, 21, 25, 32 };

        Arrays.sort(numbers);

        assertArrayEquals(expectedArray, numbers);
    }
}
