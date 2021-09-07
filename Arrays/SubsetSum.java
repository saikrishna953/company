package com.company.Arrays;

public class SubsetSum {


    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 12, 16};
        int sum = 11;

        boolean result = checkSubSets(arr, sum);
        System.out.print(result);

    }

    private static boolean checkSubSets(int[] arr, int sum) {

        boolean[][] bb = new boolean[sum + 1][arr.length + 1];

        for (int i = 0; i <= arr.length; i++) {
            bb[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            bb[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {

            for (int j = 1; j <= arr.length; j++) {

                bb[i][j] = bb[i][j - 1];
                if (i >= arr[j - 1]) {
                    bb[i][j] = bb[i][j] || bb[i - arr[j - 1]][j-1];

                }

            }
        }
        return bb[sum][arr.length];

    }
}
