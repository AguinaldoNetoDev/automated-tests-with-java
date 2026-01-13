package com.github.aguinaldoNetoDev.course.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;


public class ListWithBDDTest {

    @Test
    void mockingList_when_sizeIsCalled_shouldReturn10() {
        List<?> list = Mockito.mock(List.class);

        given(list.size()).willReturn(10);

        assertThat(list.size(), is(10));
        assertThat(list.size(), equalTo(10));
        assertThat(list.size(), notNullValue());
    }

    @Test
    void mockingList_when_sizeIsCalled_shouldReturnMultipleValues() {
        List<?> list = Mockito.mock(List.class);

        given(list.size())
                .willReturn(10)
                .willReturn(20)
                .willReturn(30);

        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(30));
        assertThat(list.size(), notNullValue());
    }

    @Test
    void mockingList_when_getIsCalled_shouldReturnAguinaldo() {
        var list = Mockito.mock(List.class);

        given(list.getFirst()).willReturn("Aguinaldo");

        assertThat(list.getFirst(), is("Aguinaldo"));
        assertThat(list.size(), notNullValue());
    }

    @Test
    void mockingList_when_getIsCalledWithArgumentMatcher_shouldReturnAguinaldo() {
        var list = Mockito.mock(List.class);

        given(list.get(Mockito.anyInt())).willReturn("Aguinaldo");

        assertThat(list.get(Mockito.anyInt()), is("Aguinaldo"));
    }

    @Test
    void mockingList_when_throwsAnExceptions() {
        var list = Mockito.mock(List.class);

        String expectedMessage = "Foo Bar!";

        Mockito.when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Foo Bar!"));

        RuntimeException result = Assertions.assertThrows(RuntimeException.class,
                () -> list.get(Mockito.anyInt()),
                "Error in this test");

        Assertions.assertEquals(expectedMessage, result.getMessage());
    }
}
