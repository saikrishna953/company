package com.company.Arrays;

public class Replace5 {

    int convertfiveRec(int num) {
        // Base case for recursion termination
        if (num == 0) return 0;

        // Extract the last digit and change it if needed
        int digit = num % 10;
        if (digit == 0) digit = 5;

        // Convert remaining digits and append the last digit
        return convertfiveRec(num / 10) * 10 + digit;
    }
    int convertfive(int num) {
        if (num == 0)
            return 5;
        else
            return convertfiveRec(num);
    }
}
