package com.github.aguinaldoNetoDev.course.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ListTest {

    @Test
    void mockingList_when_sizeIsCalled_shouldReturn10() {
        List<?> list = Mockito.mock(List.class);

        Mockito.when(list.size()).thenReturn(10);

        Assertions.assertEquals(10, list.size());
    }

    @Test
    void mockingList_when_sizeIsCalled_shouldReturnMultipleValues() {
        List<?> list = Mockito.mock(List.class);

        Mockito.when(list.size())
                .thenReturn(10)
                .thenReturn(20)
                .thenReturn(30);

        Assertions.assertEquals(10, list.size());
        Assertions.assertEquals(20, list.size());
        Assertions.assertEquals(30, list.size());
    }

    @Test
    void mockingList_when_getIsCalled_shouldReturnAguinaldo() {
        var list = Mockito.mock(List.class);

        Mockito.when(list.getFirst()).thenReturn("Aguinaldo");

        Assertions.assertEquals("Aguinaldo", list.getFirst());
        Assertions.assertNull(list.get(1));
    }

    @Test
    void mockingList_when_getIsCalledWithArgumentMatcher_shouldReturnAguinaldo() {
        var list = Mockito.mock(List.class);

        Mockito.when(list.get(Mockito.anyInt())).thenReturn("Aguinaldo");

        Assertions.assertEquals("Aguinaldo", list.get(Mockito.anyInt()));
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
