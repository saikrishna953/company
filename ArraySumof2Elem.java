package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class ArraySumof2Elem {

    public static void main(String[] args) {


        int[] arr = {1, 4, 5, 2, 6, 4, 7};

        int sum = 8;

        findElementsWithSum(arr, sum);

    }

    private static void findElementsWithSum(int[] arr, int sum) {

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i <= arr.length-1 ; i++) {

            Integer temp = Math.abs(sum - arr[i]);

            if(hs.contains(temp)){
                System.out.println("Match pair is " + temp + " and " + arr[i]);
            }
            hs.add(arr[i]);
        }
    }

    private static void findElementsWithSum1(int[] arr, int sum) {

        Arrays.sort(arr);
        int l = 0; int r = arr.length-1;
        while(l<r){

            if(arr[l] + arr[r] == sum){
                System.out.println("Match pair  is " + arr[l] + " and " + arr[r]);
            }
            if(arr[l] + arr[r] > sum){
                r--;
            }else{
                l++;
            }

        }

    }

}
