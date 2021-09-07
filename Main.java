package com.company;

import org.w3c.dom.Node;

import java.io.InputStream;
import java.util.*;

public class Main {

    static int rer = 123;
    public static void main(String[] args) {
        Optional<String> opt = Optional.of("Sai");
        opt.ifPresent(name -> System.out.println(name));
        List<String> saiList = null;

        //Optional.of(saiList);
        Optional<List<String>> opt1 = Optional.ofNullable(saiList);
        opt1.ifPresent(n -> System.out.println(n.size()));
        int[] input = {1, 1, 1, 0, 1, 1, 1, 1};
        int[] output = cellCompete(input, 2);
        System.out.println(Arrays.toString(output));

        System.out.println(palindrome("Madam In Eden Im Adam"));

        int n, reverse = 0;

        System.out.println("Enter an integer to reverse");

        n = 12345;
        while (n != 0) {
            reverse = reverse * 10;
            reverse = reverse + n % 10;
            n = n / 10;
        }

        System.out.println("Reverse of the number is " + reverse);

        //maxCharCount("test");

        /*Scanner inputs = new Scanner(System.in);
        System.out.println("Enter the number of test cases :");
        Integer testCases = inputs.nextInt();


        HashMap<Integer, List<Double>> totalList = new HashMap<>();
        for (int j = 1; j <= testCases; j++) {

            System.out.println("Test Case " + j + " details-");
            System.out.println("Enter the number of players :");
            Integer numberOfPlayers = inputs.nextInt();

            List<Double> playerPoints = new ArrayList<>();

            for (int i = 0; i < numberOfPlayers; i++) {

                System.out.println("Enter player " + (i+1) + " scored goals :");
                Integer playerGoals = inputs.nextInt();

                System.out.println("Enter player " + (i+1) + " penalties :");

                Integer playerPenalties = inputs.nextInt();
                Double playerPointsValue = (double)(playerGoals * 20) - (playerPenalties * 10);

                playerPoints.add(playerPointsValue);

            }
            totalList.put(j,playerPoints);
        }
///football problem
        totalList.forEach((integer, doubles) -> {
            System.out.println(doubles.stream().max(Double :: compare).get());
        });*/


        //System.out.println(totalList.toString());

        int[] intArray = {2,4,6,8,10};

        System.out.println("GCD ouput:" + findGCD(intArray));
        System.out.println(findProblem1());
        findProblem2(10);
        /*for (Map.Entry<Integer, HashMap> entry:
             totalList.entrySet()) {

            entry.getValue().forEach((goals, penalties) -> {
                for (int i = 0; i <goals.size ; i++) {

                }
            });
            
        }*/
        //assert testCases.intValue() < 101 : "Test Cases number should be between 0 and 100 ";



    }

    public static int[] cellCompete(int[] cells, int days) {
        int oldCell[] = Arrays.copyOf(cells, cells.length);
        for (Integer k = 0; k < days; k++) {
            for (Integer j = 1; j < oldCell.length - 1; j++) {
                if ((oldCell[j - 1] == 1 && oldCell[j + 1] == 1) || (oldCell[j - 1] == 0 && oldCell[j + 1] == 0)) {
                    cells[j] = 0;
                } else {
                    cells[j] = 1;
                }
            }
            if (oldCell[1] == 0) {
                cells[0] = 0;
            } else {
                cells[0] = 1;
            }
            if (oldCell[oldCell.length - 2] == 0) {
                cells[cells.length - 1] = 0;
            } else {
                cells[cells.length - 1] = 1;
            }
            oldCell = cells.clone();
        }
        return cells;

    }

    public static boolean palindrome(String name) {

        String modName = name.replaceAll(" ", "");
        StringBuilder sai = new StringBuilder(modName);
        if (sai.reverse().toString().equalsIgnoreCase(modName)) {
            return true;
        }

        return false;

    }

    public static void maxCharCount(String name) {

        int countArray[] = new int[256];

        for (char var : name.toCharArray()
        ) {
            countArray[var]++;
        }

        System.out.println(Arrays.toString(countArray));

    }

    public static int findGCD(int num1, int num2) {

        if (num2 == 0) {
            return num1;
        }

        return findGCD(num2, num1%num2);
    }

    public static int findGCD(int... arr) {

        int temp = 0;
        for (int i = 0; i < arr.length -1 ; i++) {
            if (i == 0) {
                temp = findGCD(arr[i], arr[i + 1]);
            }else{
                findGCD(temp,arr[i+1]);
            }

        }

        return temp;
    }

    //PROBLEM 1:
    // If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    //
    //Find the sum of all the multiples of 3 or 5 below 1000.

    public static long findProblem1() {

        long sum = 0;
        for (int i = 1; i < 10 ; i++) {


            if (i>2 && (i%3 == 0 || i%5 == 0) ){
                sum =  sum + i;
            }

        }
        return sum;
    }

    //Problem 2:
    // Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
    //
    //1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    //
    //By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
    public static void findProblem2(int N) {

        int n1=0,n2=1,n3=0;

        System.out.println("0 1");

        while (N > 0){
            n3 = n2 + n1;
            n1 = n2;
            n2= n3;

            System.out.print(" " + n3);
            N--;
        }

    }
}
