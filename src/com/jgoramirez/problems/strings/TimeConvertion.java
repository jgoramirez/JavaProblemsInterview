package com.jgoramirez.problems.strings;

import java.io.*;

public class TimeConvertion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        String[] times = s.split(":");

        int timeHour = Integer.parseInt(times[0]);
        if (timeHour == 12) timeHour = 0;
        if (times[2].contains("AM")) {
            times[2] = times[2].replace("AM", "");
        } else {
            timeHour = timeHour+12;
            times[2] = times[2].replace("PM", "");
        }

        String timeFormated = String.format("%02d", timeHour);

        return timeFormated+":"+times[1]+":"+times[2];

    }

}