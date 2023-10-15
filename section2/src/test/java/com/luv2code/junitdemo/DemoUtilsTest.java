package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setUp() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Test equals and not equals")
    @Order(1)
    void testEqualsAndNotEquals() {
        // set up
        int expected = 6;
        int unexpected = 8;

        // execute
        int actual = demoUtils.add(2, 4);

        // assert
        assertEquals(expected, actual);
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Test null and not null")
    @Order(0)
    void testNullAndNotNull() {
        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    @DisplayName("Same and not same")
    void testSameAndNotSame() {
        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to the same object");
    }

    @Test
    @DisplayName("True and false")
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @Test
    @DisplayName("Arrays equals")
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @Test
    @DisplayName("Iterables should match")
    void testIterablesShouldMatch() {
        List<String> theList = List.of("luv", "2", "code");

        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be the same");
    }

    @Test
    @DisplayName("Lines should match")
    void testLinesShouldMatch() {
        List<String> theList = List.of("luv", "2", "code");

        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Expected list should be the same");
    }

    @Test
    @DisplayName("Throws and not throws")
    void testThrowsAndNotThrows() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1), "Should throw exception");
        assertDoesNotThrow(() -> demoUtils.throwException(1), "Should not throw exception");
    }

    @Test
    @DisplayName("Check timeout")
    void testCheckTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(), "Method should execute in 3 seconds");
    }

    @Test
    @DisplayName("Multiply")
    void testMultiply() {
        assertEquals(12, demoUtils.multiply(3,4), "3 * 4 must be 12");
    }

    /*
    @AfterEach
    void tearDown(){
        System.out.println("Cleaning up");
    }

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("Execute before all");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Cleanup after all");
    }

     */
}
