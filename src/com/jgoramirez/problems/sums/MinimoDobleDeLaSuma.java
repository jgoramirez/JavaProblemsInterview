package com.jgoramirez.problems.sums;

public class MinimoDobleDeLaSuma {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int N1 = 14;
        System.out.println(solution.solution(N1));

        int N2 = 99;
        System.out.println(solution.solution(N2));

        int N3 = 10;
        System.out.println(solution.solution(N3));

    }

}

class Solution {
    public int solution(int N) {
        return findSmallestNumber(N);
    }

    private int sumDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    private int findSmallestNumber(int n) {
        int sumN = sumDigits(n);

        int candidate = n + 1;
        while (true) {
            int sumCandidate = sumDigits(candidate);
            if (sumCandidate == 2 * sumN) {
                return candidate;
            } else if (sumCandidate > 2 * sumN) {
                break;
            }
            candidate++;
        }
        return -1;
    }

    private int findSmallestNumber2(int n) {
        int sumN = sumDigits(n);

        int candidate = n+1;
        while(true) {
            int sumCandidate = sumDigits(candidate);
            if (sumCandidate == (2*sumN)) {
                return candidate;
            } else if (sumCandidate > (2*sumN)) {
                break;
            }
            candidate++;
        }
        return -1;
    }

}