package com.company.Practise_Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String... args){
        int arr[] = {64,25,12,22,11};
        //selectionSort(arr);
        //bubbleSort(arr);
        //insertionSort(arr);
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);

        int arr1[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.print(kadane(arr1));


        HashMap<String,Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 15);
        map.put("C", 20);
        map.put("D", 25);
        Map.Entry<String,Integer> maxEntry = Collections.max(map.entrySet(), Comparator.comparing(Map.Entry::getValue));
        System.out.print("\nMax Value in map - "+ maxEntry.getValue());

    }

    private static void selectionSort(int[] arr){

        int minidx = 0;
        for (int i = 0; i < arr.length; i++) {
            minidx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minidx]){
                    minidx = j;
                }

            }
            int temp = arr[minidx];
            arr[minidx] = arr[i];
            arr[i] = temp;

        }

    }
    private static<T> void swap(T a, T b){
        T temp = a;
        a = b;
        b = temp;
    }

    private static void bubbleSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }


        }

    }

    private static void insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;

        }

    }

    private static void quickSort(int[] arr, int low, int high){

        if(low<high){

            int pivot_indx = partition1(arr,low,high);

            quickSort(arr,low,pivot_indx-1);
            quickSort(arr,pivot_indx+1,high);

        }

    }

    private static int partition1(int[] arr,int low, int high) {

        int j = low-1;
        int pivot = arr[high];
        for (int i = low; i < high ; i++) {

            if(arr[i] <= pivot){
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }

        }
        int temp = arr[j+1];
        arr[j+1] = arr[high];
        arr[high] = temp;

        return j+1;
    }

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    private static int kadane(int[] arr){

        int max_so_far = 0;
        int max_end = 0;
        int start = 0;
        int j = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {

            if(arr[i] > (max_so_far+arr[i])){
                start = i;
            }
            max_so_far = Math.max(arr[i],max_so_far+arr[i]);

            if(max_so_far>max_end){
                j=start;
                end = i;
            }
            max_end = Math.max(max_so_far,max_end);

        }
        System.out.print("Start-" + j);
        System.out.println("end-" + end);
        return max_end;

    }
}
