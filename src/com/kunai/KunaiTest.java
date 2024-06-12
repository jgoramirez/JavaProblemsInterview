package com.kunai;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KunaiTest {

    @Test
    void isPar() {

        int[] numbers = {0,80,25,65,12,38,76,28,94,45,85893};
        boolean[] expected = new boolean[]{true, true, false, false, true, true, true, true, true, false, false};

        boolean[] result = Kunai.isPar(numbers);

        assertEquals(Arrays.toString(expected), Arrays.toString(result));

    }

}