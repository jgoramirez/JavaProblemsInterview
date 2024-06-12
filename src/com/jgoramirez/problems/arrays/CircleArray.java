package com.jgoramirez.problems.arrays;

public class CircleArray {

    public int[] solution(int[] A, int K) {
        int times = K % A.length;
        if (K == 0 || K == A.length || times == 0) return A;

        for (int i = 0; i < times; i++) {
            switchArray(A);
        }
        return A;

    }

    private void switchArray(int[] A) {

        int size = A.length -1;
        int tmpValue = -1;
        int backupNumber = 0;
        int pos = 0;

        for (int i = 0; i < size; i++) {
            pos = i+1;
            if (tmpValue >= 0) {
                backupNumber = A[pos];
                A[pos] = tmpValue;
                tmpValue = backupNumber;
            } else {
                tmpValue = A[pos];
                A[pos] = A[i];
            }
        }

        if (tmpValue >= 0) {
            A[0] = tmpValue;
        }

    }

}

