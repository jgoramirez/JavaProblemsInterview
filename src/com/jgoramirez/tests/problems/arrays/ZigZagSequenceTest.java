package com.jgoramirez.tests.problems.arrays;

import com.jgoramirez.problems.arrays.ZigZagSequence;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.jgoramirez.problems.arrays.ZigZagSequence.findZigZagSequence;
import static org.junit.jupiter.api.Assertions.*;
class ZigZagSequenceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testCase1() {
        int[] a = {1,2,3,4,5,6,7};
        int n = a.length;

        findZigZagSequence(a, n);
        assertEquals("1 2 3 7 6 5 4", outContent.toString());

    }

}