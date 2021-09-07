package com.company;

import java.util.*;

class GFG
{

    // Function to find greatest number
    static int findGreatest(int arr[], int n)
    {
        // Store occurrences of all
        // elements in hash array
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            if (m.containsKey(arr[i]))
            {
                m.put(arr[i], m.get(arr[i]) + 1);
            }
            else
            {
                m.put(arr[i], m.get(arr[i]));
            }
        }

        // m[arr[i]]++;
        // Sort the array and traverse
        // all elements from end.
        Arrays.sort(arr);

        for (int i = n - 1; i > 1; i--)
        {
            // For every element, check if there is another
            // element which divides it.
            for (int j = 0; j < i &&
                    arr[j] <= Math.sqrt(arr[i]); j++)
            {
                if (arr[i] % arr[j] == 0)
                {
                    int result = arr[i] / arr[j];

                    // Check if the result value exists in array
                    // or not if yes the return arr[i]
                    if (result != arr[j] &&
                            m.get(result) == null|| m.get(result) > 0)
                    {
                        return arr[i];
                    }

                    // To handle the case like arr[i] = 4
                    // and arr[j] = 2
                    else if (result == arr[j] && m.get(result) > 1)
                    {
                        return arr[i];
                    }
                }
            }
        }
        return -1;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {17, 2, 1, 15, 30};
        int n = arr.length;
        System.out.println(findGreatest(arr, n));
    }
}
