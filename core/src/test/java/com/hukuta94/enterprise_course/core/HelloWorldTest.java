package com.hukuta94.enterprise_course.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    @DisplayName("Basic 'hello world' test should be succeed")
    void helloWorldTest() {
        Assertions.assertEquals("Hello world!", HelloWorld.getHello());
    }

}
