package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    @Test
    @DisplayName("Divisible by 3")
    @Order(1)
    void testForDivisibleBy3() {
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return " + expected);
    }

    @Test
    @DisplayName("Divisible by 5")
    @Order(2)
    void testForDivisibleBy5() {
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "Should return " + expected);
    }

    @Test
    @DisplayName("Divisible by 3 and 5")
    @Order(3)
    void testForDivisibleBy3And5() {
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "Should return " + expected);
    }

    @Test
    @DisplayName("Not divisible by 3 and 5")
    @Order(4)
    void testForDivisibleBy15() {
        String expected = "1";

        assertEquals(expected, FizzBuzz.compute(1), "Should return " + expected);
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @DisplayName("Testing with small data file")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void testSmallDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @DisplayName("Testing with medium data file")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void testMediumDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @DisplayName("Testing with large data file")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(7)
    void testLargeDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }
}
