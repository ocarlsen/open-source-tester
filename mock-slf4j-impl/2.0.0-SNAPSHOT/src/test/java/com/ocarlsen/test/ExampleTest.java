package com.ocarlsen.test;

import org.junit.Test;
import org.mockito.InOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.inOrder;


/**
 * See <a href="https://github.com/ocarlsen/mock-slf4j-impl/blob/main/src/test/java/com/ocarlsen/test/ExampleTest.java>ExampleTest.java</a>
 */
public abstract class ExampleTest {

    @Test
    public void testLogging() {

        // Given
        final MyLoggingClass loggingInstance = new MyLoggingClass();

        // When
        loggingInstance.loggingMethod();

        // Then
        final Logger mockLogger = LoggerFactory.getLogger("MyLoggingClass");

        final InOrder inOrder = inOrder(mockLogger);
        inOrder.verify(mockLogger).debug("this is a debug message");
        inOrder.verify(mockLogger).info("this is an info message");
        inOrder.verify(mockLogger).warn("this is a warn message");
        inOrder.verify(mockLogger).error("this is an error message");
        inOrder.verifyNoMoreInteractions();
    }

    static class MyLoggingClass {

        private final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

        public void loggingMethod() {
            logger.debug("this is a debug message");
            logger.info("this is an info message");
            logger.warn("this is a warn message");
            logger.error("this is an error message");
        }
    }
}