package com.github.aguinaldoNetoDev.course.mockito;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestMatchersTest {

    @Test
    void testHamcrestMatchersTest() {
        //Given
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        //When & Then
        assertThat(scores, Matchers.hasSize(4));
        assertThat(scores, Matchers.hasItems(100, 105));
        assertThat(scores, Matchers.everyItem(Matchers.greaterThan(98)));
        assertThat(scores, Matchers.everyItem(Matchers.lessThan(106)));

        //check Strings
        assertThat("", Matchers.is(Matchers.emptyString()));
        assertThat(null, Matchers.is(Matchers.nullValue()));

        //check Arrays
        Integer[] myArray = {1, 2, 3};

        assertThat(myArray, Matchers.arrayWithSize(3));
        assertThat(myArray, Matchers.arrayContaining(1, 2, 3));
        assertThat(myArray, Matchers.arrayContainingInAnyOrder(2, 3, 1));
    }
}
