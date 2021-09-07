package com.company.Recursion;

import java.time.Instant;

public class App {

    public static void main(String[] args) {

        Algorithm algorithm = new Algorithm();
        algorithm.tailRecursion(6);
        algorithm.headRecursion(6);

        long start = Instant.now().toEpochMilli();

        System.out.println(algorithm.calculateFactorial(7));
        long end = Instant.now().toEpochMilli();
        //Duration interval = Duration.between(start,end);
        long interval = start - end;
        System.out.println(interval);

        algorithm.towersOfHanoi(3, 'A', 'B', 'C');

    }
}
