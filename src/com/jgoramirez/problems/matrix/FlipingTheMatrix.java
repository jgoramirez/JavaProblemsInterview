package com.jgoramirez.problems.matrix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {

        printMatrix(matrix);
        sumByQuadrant(matrix);
        System.out.println(sumFirstQuadrant(matrix));
        flipColumnMatrix(matrix, 2);
        sumByQuadrant(matrix);
        flipRowMatrix(matrix, 0);
        printMatrix(matrix);
        System.out.println(sumFirstQuadrant(matrix));
        sumByQuadrant(matrix);

        //return calculateMaxSum(matrix);
        return 0;

    }

    public static long calculateMaxSum(List<List<Integer>> matrix) {
        int n = matrix.size();
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSum += Math.max(
                        Math.max(matrix.get(i).get(j), matrix.get(2 * n - 1 - i).get(j)),
                        Math.max(matrix.get(i).get(2 * n - 1 - j), matrix.get(2 * n - 1 - i).get(2 * n - 1 - j))
                        );
            }
        }
        return maxSum;
    }

    public static void sumByQuadrant(List<List<Integer>> matrix) {
        int sum = 0;
        int matrixSize = matrix.size();
        int quadrantSize = matrixSize/2;

        for (int i = 0; i < quadrantSize; i++) {
            for (int j = 0; j < quadrantSize; j++) {
                sum += matrix.get(i).get(j);
            }
        }
        System.out.println("Quadrant 1="+sum);
        sum = 0;
        for (int i = 0; i < quadrantSize; i++) {
            for (int j = quadrantSize; j < matrixSize; j++) {
                sum += matrix.get(i).get(j);
            }
        }
        System.out.println("Quadrant 2="+sum);
        sum = 0;
        for (int i = quadrantSize; i < matrixSize; i++) {
            for (int j = 0; j < quadrantSize; j++) {
                sum += matrix.get(i).get(j);
            }
        }
        System.out.println("Quadrant 3="+sum);
        sum = 0;
        for (int i = quadrantSize; i < matrixSize; i++) {
            for (int j = quadrantSize; j < matrixSize; j++) {
                sum += matrix.get(i).get(j);
            }
        }
        System.out.println("Quadrant 4="+sum);

    }

    public static int sumFirstQuadrant(List<List<Integer>> matrix) {
        int sum = 0;
        int quadrantSize = matrix.size()/2;

        for (int i = 0; i < quadrantSize; i++) {
            for (int j = 0; j < quadrantSize; j++) {
                sum += matrix.get(i).get(j);
            }
        }

        return sum;

    }

    public static void flipColumnMatrix(List<List<Integer>> matrix, int column) {
        int end = matrix.size()-1;
        int start = 0;
        int tmpNumber = 0;

        while (start < end) {
            tmpNumber = matrix.get(start).get(column);
            matrix.get(start).set(column, matrix.get(end).get(column));
            matrix.get(end).set(column, tmpNumber);

            start++;
            end--;
        }
    }

    public static void flipRowMatrix(List<List<Integer>> matrix, int row) {

        int end = matrix.size()-1;
        int start = 0;
        int tmpNumber = 0;

        while (start < end) {
            tmpNumber = matrix.get(row).get(start);
            matrix.get(row).set(start, matrix.get(row).get(end));
            matrix.get(row).set(end, tmpNumber);

            start++;
            end--;
        }


    }

    public static void printMatrix(List<List<Integer>> matrix) {

        for (List<Integer> column : matrix) {
            for (Integer row : column) {
                System.out.print(row + ", ");
            }
            System.out.println();
        }

    }

}

public class FlipingTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.flippingMatrix(matrix);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
