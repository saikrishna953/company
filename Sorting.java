package com.company;

public class Sorting {

    public static void main(String... args){

        selectionSort ss = new selectionSort();
        BubbleSort bs = new BubbleSort();
        InsertionSort is = new InsertionSort();
        MergeSort ms = new MergeSort();

        int arr[] = {8, 22, 7, 9, 31, 5, 13};
        ms.sort(arr,0,arr.length);
        is.sort(arr);
        int count = bs.sort(arr, arr.length);

        System.out.println("BS Sorted swap count: " + count);
        bs.printArray(arr,arr.length);

    }

}
