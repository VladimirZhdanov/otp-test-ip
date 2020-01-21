package com.otp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static com.otp.Constants.BAD_FORMAT;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
class AlgorithmTest {
    public Algorithm algorithm;

    @BeforeEach
    public void setUp() {
        algorithm = new Algorithm();
    }

    @Test
    public void shouldReturnCorrectedListWhenGetResult() throws UnknownHostException {
        String first = "192.168.0.1";
        String last = "192.168.0.4";

        List<String> expected = new ArrayList<>();
        expected.add("192.168.0.1");
        expected.add("192.168.0.2");
        expected.add("192.168.0.3");
        expected.add("192.168.0.4");

        algorithm.setResult(first, last);

        assertEquals(expected, algorithm.getResult());
    }

    @Test
    public void shouldReturnCorrectedBigListWhenGetResult() throws UnknownHostException {
        String first = "192.168.1.254";
        String last = "192.168.2.4";

        List<String> expected = new ArrayList<>();
        expected.add("192.168.1.254");
        expected.add("192.168.1.255");
        expected.add("192.168.2.0");
        expected.add("192.168.2.1");
        expected.add("192.168.2.2");
        expected.add("192.168.2.3");
        expected.add("192.168.2.4");

        algorithm.setResult(first, last);

        assertEquals(expected, algorithm.getResult());
    }

    @Test
    public void shouldReturnEmptyListListWhenGetResult() throws UnknownHostException {
        String first = "192.168.0.1";
        String last = "192.168.0.0";

        List<String> expected = new ArrayList<>();

        algorithm.setResult(first, last);

        assertEquals(expected, algorithm.getResult());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenBadFormatWasPassedToSetResult() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                algorithm.setResult("null", "192.168.0.1"));
        assertEquals(BAD_FORMAT, exception.getMessage());
    }
}