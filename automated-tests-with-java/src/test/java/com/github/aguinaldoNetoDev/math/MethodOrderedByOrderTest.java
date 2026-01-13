package com.github.aguinaldoNetoDev.math;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(4)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderTest {

    @Test
    @Order(3)
    void testA() {
        System.out.println("Running Test A");
    }

    @Test
    @Order(1)
    void testB() {
        System.out.println("Running Test B");
    }

    @Test
    @Order(4)
    void testC() {
        System.out.println("Running Test C");
    }

    @Test
    @Order(2)
    void testD() {
        System.out.println("Running Test D");
    }

}
