package com.jgoramirez.problems.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Results {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);

        long sum = 0;
        for (long num : arr) {
            sum += num;
        }

        long minSum = sum - arr.get(4);
        long maxSum = sum - arr.get(0);

        System.out.println(minSum + " " + maxSum);

    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Results.miniMaxSum(arr);

        bufferedReader.close();
    }
}
