package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTest {
    @Test
    @Disabled("Don't run until ticket 123 is fixed")
    void basicTest() {
        // do some test
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {
        // do some test
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly() {
        // do some test
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testForMacAndWindowsOnly() {
        // do some test
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testJava17() {
        // do some test
    }

    @Test
    @EnabledOnJre(JRE.JAVA_13)
    void testJava13() {
        // do some test
    }

    @Test
    @EnabledForJreRange(min=JRE.JAVA_13, max = JRE.JAVA_18)
    void testJava13To18() {
        // do some test
    }

    @Test
    @EnabledForJreRange(min=JRE.JAVA_11)
    void testJava11Plus() {
        // do some test
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "LUV2CODE_ENV", matches = "DEV")
    void testOnlyForDevEnv() {
        // do some test
    }

    @Test
    @EnabledIfSystemProperty(named = "LUV2CODE_SYSPROP", matches = "CI_CD_DEPLOY")
    void testOnlyForSystemProperties() {
        // do some test
    }
}
