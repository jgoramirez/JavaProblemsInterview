package com.kunai;

public class Kunai {

    public static boolean[] isPar(int[] a) {

        int size = a.length;
        boolean[] isPar = new boolean[size];

        for (int i = 0; i < size-1; i++) {
            if (a[i] % 2 == 0) {
                isPar[i] = true;
            } else {
                isPar[i] = false;
            }
        }

        return isPar;

    }

}
