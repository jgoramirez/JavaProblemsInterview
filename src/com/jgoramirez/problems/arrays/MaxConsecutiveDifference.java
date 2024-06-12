package com.jgoramirez.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveDifference {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] A1 = {3, 6, 9, 12, 15};
        System.out.println(solution.solution(A1));

        int[] A2 = {4, 3, 5, 1, 4, 4};
        System.out.println(solution.solution(A2));

        int[] A3 = {12, 12, 12, 15, 10};
        System.out.println(solution.solution(A3));

        int[] A4 = {18,26,18,24,24,20,22};
        System.out.println("Expected 5, got: "+solution.solution(A4));

        int[] A5 = {4,7,1,5,3};
        System.out.println("Expected 4, got: "+solution.solution(A5));



    }

}

class Solution {

    public int solution(int[] A) {
        return pairwiseDifference(A);
    }

    public static int pairwiseDifference(int arr[])
    {
        int n = arr.length;
        int diff = 0;
        for (int i = 0; i < n - 1; i++) {
            diff = Math.abs(arr[i] - arr[i + 1]);
            System.out.print(diff+" ");
        }
        return diff;
    }

    public static int maxIntegersWithEqualDifferences(int[] A) {
        // Create a map to store the frequency of each unique number in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;

        // Iterate through the frequency map
        for (int num : frequencyMap.keySet()) {
            int count = 0;
            int current = num;

            // Count the number of integers that can form a sequence with equal differences
            while (frequencyMap.containsKey(current)) {
                count += frequencyMap.get(current);
                current += 1; // Move to the next integer in the sequence
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }


    public static int maxConsecutiveElements(int[] A) {
        // Ordena el arreglo en orden ascendente
        Arrays.sort(A);

        int maxConsecutive = 0;
        int currentConsecutive = 1; // Inicialmente, consideramos el primer elemento como una secuencia

        // Itera sobre el arreglo para verificar las diferencias entre los pares consecutivos
        for (int i = 1; i < A.length; i++) {
            // Si la diferencia entre los elementos consecutivos es igual a la diferencia entre
            // los primeros dos elementos, incrementa la longitud de la secuencia actual
            if (A[i] - A[i - 1] == A[1] - A[0]) {
                currentConsecutive++;
            } else {
                // Si la diferencia es diferente, actualiza el máximo y reinicia el contador
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
                currentConsecutive = 1; // Reinicia el contador
            }
        }

        // Actualiza el máximo final
        maxConsecutive = Math.max(maxConsecutive, currentConsecutive);

        return maxConsecutive;
    }

    public static int maxConsecutiveElements2(int[] A) {
        // Ordena el arreglo en orden ascendente
        Arrays.sort(A);

        int maxConsecutive = 0;

        // Itera sobre el arreglo para verificar las diferencias entre los pares consecutivos
        for (int i = 0; i < A.length - 1; i++) {
            int diff = A[i + 1] - A[i];
            int currentConsecutive = 1; // Inicialmente, consideramos el par actual como una secuencia

            // Itera sobre los pares consecutivos con la misma diferencia
            for (int j = i + 1; j < A.length - 1; j++) {
                if (A[j + 1] - A[j] == diff) {
                    currentConsecutive++;
                } else {
                    break; // Rompe el ciclo si la diferencia es diferente
                }
            }

            // Actualiza el máximo encontrado hasta el momento
            maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
        }

        return maxConsecutive;
    }

}