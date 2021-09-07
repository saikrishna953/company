package com.company.Arrays;

public class Candies {
    // Java code for better approach
// to distribute candies


    // Function to find out the number of
    // candies every person received
    static void candiesX(int n, int k){
        int[] res =  new int[k];
        for(int i=0;n>0;i++){
            res[i%k] += Math.min(n,i+1);
            n -= i+1;
        }
        System.out.println(" ");
        for (int i = 0; i < k; i++)
            System.out.print(res[i] + " ");

    }
    static void candies(int n, int k) {

        // Count number of complete turns
        int count = 0;

        // Get the last term
        int ind = 1;

        // Stores the number of candies
        int[] arr = new int[k];

        for (int i = 0; i < k; i++)
            arr[i] = 0;


        int low = 0, high = n;

        // Do a binary search to find the number whose
        // sum is less than N.
        while (low <= high) {

            // Get mide
            int mid = (low + high) >> 1;
            int sum = (mid * (mid + 1)) >> 1;

            // If sum is below N
            if (sum <= n) {

                // Find number of complete turns
                count = mid / k;

                // Right halve
                low = mid + 1;
            } else {

                // Left halve
                high = mid - 1;
            }
        }

        // Last term of last complete series
        int last = (count * k);

        // Subtract the sum till
        n -= (last * (last + 1)) / 2;

        int j = 0;

        // First term of incomplete series
        int term = (count * k) + 1;

        while (n > 0) {
            if (term <= n) {
                arr[j++] = term;
                n -= term;
                term++;
            } else {
                arr[j] += n;
                n = 0;
            }
        }

        // Count the total candies
        for (int i = 0; i < k; i++)
            arr[i] += (count * (i + 1))
                    + (k * (count * (count - 1)) / 2);

        // Print the total candies
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 10, k = 3;
        candies(n, k);
        candiesX(n,k);


    }

}
