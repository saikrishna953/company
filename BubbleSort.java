package com.company;

import java.util.Arrays;

class BubbleSort {
    // An optimized version of Bubble Sort
    static int sort(int arr[], int n) {
        int i, j, temp;
        boolean swapped;
        int count = 0;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                    //swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            /*if (swapped == false)
                break;*/
        }
        return count;
    }

    // Function to print an array
    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void bubbleSort(int[] lst) {
        int n = lst.length;
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                if (lst[i] > lst[i+1]) {
                    int temp = lst[i];
                    lst[i] = lst[i+1];
                    lst[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped == true);

        System.out.println(Arrays.toString(lst));
    }

}
