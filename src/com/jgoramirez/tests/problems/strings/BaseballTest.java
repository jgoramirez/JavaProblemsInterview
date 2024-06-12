package com.jgoramirez.tests.problems.strings;

import com.jgoramirez.problems.strings.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BaseballTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calPoints() {

        String[] ops = new String[]{"5","2","C","D","+"};
        int expected = 30;

        int result = Baseball.calPoints(ops);

        assertEquals(expected, result);

    }

    @Test
    void calPoints2() {

        String[] ops = new String[]{"5","-2","4","C","D","9","+","+"};
        int expected = 27;

        int result = Baseball.calPoints(ops);

        assertEquals(expected, result);
    }

    @Test
    void calPoints3() {

        String[] ops = new String[]{"1"};
        int expected = 1;

        int result = Baseball.calPoints(ops);

        assertEquals(expected, result);
    }

}