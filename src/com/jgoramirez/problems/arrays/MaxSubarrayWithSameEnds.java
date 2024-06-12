package com.jgoramirez.problems.arrays;

public class MaxSubarrayWithSameEnds {

    public static int maxSubarrayWithSameEnds(int[] arr) {
        return solution2(arr);
    }

    public static int solution2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Calcular las sumas acumulativas de los subarrays
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
            for (int j = i+1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + arr[j];
            }
        }

        int maxSum = 0;
        boolean found = false;

        // Buscar el subarray con la suma máxima que cumple con la condición dada
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    maxSum = Math.max(maxSum, dp[i][j]);
                    found = true;
                }
            }
        }

        if (!found) {
            return -1; // No se encontró ningún subarray que cumpla con la condición
        }

        return maxSum;
    }

    public static int solution1(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Calcular las sumas acumulativas de los subarrays
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
            for (int j = i+1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + arr[j];
            }
        }

        int maxSum = 0;

        // Buscar el subarray con la suma máxima que cumple con la condición dada
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    maxSum = Math.max(maxSum, dp[i][j]);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5, 2, 4, 1};
        int resultado = maxSubarrayWithSameEnds(A);
        System.out.println("La suma máxima de un subarray con los mismos extremos es: " + resultado);

        int[] A1 = {1,3,6,1,6,6,9,9};
        System.out.println(maxSubarrayWithSameEnds(A1));

        int[] A2 = {5,1,4,3};
        System.out.println(maxSubarrayWithSameEnds(A2));
    }
}
