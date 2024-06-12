package com.jgoramirez.tests.problems.arrays;

import com.jgoramirez.problems.arrays.CircleArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CircleArrayTest {

    CircleArray circleArray;

    @BeforeEach
    void setUp() {
        circleArray = new CircleArray();
    }

    @Test
    public void test0() {
        int K = 3;
        int[] A = {3, 8, 9, 7, 6};

        int[] expected = {9, 7, 6, 3, 8};

        circleArray.solution(A,K);

        assertEquals(Arrays.toString(expected), Arrays.toString(A));

    }

    @Test
    public void test1() {
        int K = 4;
        int[] A = {1, 2, 3, 4};

        int[] expected = {1, 2, 3, 4};

        circleArray.solution(A,K);

        assertEquals(Arrays.toString(expected), Arrays.toString(A));

    }

    @Test
    public void test2() {
        int K = 1;
        int[] A = {0, 0, 0};

        int[] expected = {0, 0, 0};

        circleArray.solution(A,K);

        assertEquals(Arrays.toString(expected), Arrays.toString(A));

    }

}