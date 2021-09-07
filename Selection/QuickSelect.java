package com.company.Selection;

import java.util.Random;

public class QuickSelect {

    public int[] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }


    public int select(int firstIndex, int lastIndex, int k) {

        int pivot = partition(firstIndex, lastIndex);

        if (pivot > k) {
            return select(firstIndex, pivot - 1, k);
        } else if (pivot < k) {
            return select(pivot + 1, lastIndex, k);
        }

        return nums[k];

    }

    private int partition(int firstIndex, int lastIndex) {

        int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;


        swap(lastIndex, pivot);

        for (int i = firstIndex; i < lastIndex; i++) {
            if (nums[i] > nums[lastIndex]) {
                swap(i, firstIndex);
                firstIndex++;
            }

        }
        swap(firstIndex, lastIndex);
        return firstIndex;

    }

    private void swap(int lastIndex, int pivot) {
        int temp = pivot;
        pivot = lastIndex;
        lastIndex = temp;
    }
}
