package com.company.Recursion;

public class Algorithm {


    public void tailRecursion(int N) {

        if (N == 0) return;

        tailRecursion(N - 1);
        System.out.println(N);
    }

    public void headRecursion(int N) {

        if (N == 0) return;
        System.out.println(N);
        headRecursion(N - 1);

    }

    public int factorialWithAccumulator(int accumulator, int N) {
        if (N == 1) return accumulator;
        return factorialWithAccumulator(accumulator * N, N - 1);
    }

    public int calculateFactorialWithAccumulator(int N) {
        return factorialWithAccumulator(1, N);
    }

    public int factorial(int N) {
        if (N == 1) return 1;
        return N * factorial(N - 1);
    }

    public int calculateFactorial(int N) {
        return factorial(N);
    }

    public void towersOfHanoi(int N, char rodFrom, char middleRod, char rodTo) {

        if (N == 1) {
            System.out.println("Plate " + N + " shifted from " + rodFrom + " to " + rodTo);
            return;
        }

        towersOfHanoi(N - 1, rodFrom, rodTo, middleRod);
        System.out.println("Plate " + N + " shifted from " + rodFrom + " to " + rodTo);
        towersOfHanoi(N - 1, middleRod, rodFrom, rodTo);

    }
}
