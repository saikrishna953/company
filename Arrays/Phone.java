package com.company.Arrays;

import java.util.ArrayList;
import java.util.Collections;

class PhoneDigit {
    // String array to store keypad characters
    static String hash[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static void possibleWords(int arr[], int N) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < N; i++)
            str.append(arr[i]);
        ArrayList<String> res = possibleWordsUtil(str.toString());
        Collections.sort(res); // arrange all possible strings lexicographically
        for (String s : res)
            System.out.print(s + " ");

    }

    static ArrayList<String> possibleWordsUtil(String str) {
        // If str is empty
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");

            // Return an Arraylist containing
            // empty string
            return baseRes;
        }

        // First character of str
        char ch = str.charAt(0);


        // Rest of the characters of str
        String restStr = str.substring(1);

        // get all the combination
        ArrayList<String> prevRes = possibleWordsUtil(restStr);
        ArrayList<String> Res = new ArrayList<>();

        String code = hash[ch - '0'];

        for (String val : prevRes) {

            for (int i = 0; i < code.length(); i++) {
                Res.add(code.charAt(i) + val);
            }
        }
        return Res;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,4};
        possibleWords(arr,3);
    }
}


