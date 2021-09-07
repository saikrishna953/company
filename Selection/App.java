package com.company.Selection;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] nums = {1, 23, 34, -4, 5, 6, 7};
        QuickSelect qs = new QuickSelect(nums);
        System.out.println(qs.select(0,nums.length-1,1));
        Arrays.stream(nums).sorted().forEach(System.out::println);
    }
}
