package com.jgoramirez.problems.arrays;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int n = arr.size();
        int positives = 0, negatives = 0, zeros = 0;

        for (Integer number : arr) {
            if (number > 0) positives++;
            else if(number == 0) zeros++;
            else negatives++;
        }

        double[] valores = new double[3];
        valores[0] = divideDoubles(positives, n);
        valores[1] = divideDoubles(negatives, n);
        valores[2] = divideDoubles(zeros, n);

        for (int i = 0; i < valores.length; i++) {
            System.out.println(String.format("%.6f", valores[i]));
        }

    }

    public static double divideDoubles(int number, int size) {
        DecimalFormat df = new DecimalFormat("#.######");
        double result = 0;
        if (number != 0) {
            result = (double) number/size;
        }
        return Double.parseDouble(df.format(result));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
