package com.company.DP;

import java.util.Arrays;

public class CountPS {

    public static int cntPS(char[] str,String org){
        int n =str.length;
        int d[][] = new int[n][n];
        boolean P[][] = new boolean[n][n];

        for (int i= 0; i< n; i++)
            P[i][i] = true;

        for (int i= 0; i< n-1; i++){

            if(str[i] == str[i+1]){
                P[i][i+1]=true;
                d[i][i+1] =1;
            }
        }

        int j=0;
        for(int gap=2;gap<n;gap++){

            for(int i =0;i<n-gap;i++){

                j=gap+i;
                if(str[i]==str[j] && P[i+1][j-1]){
                    P[i][j]=true;
                }
                if(P[i][j] == true){
                    d[i][j] = 1 + d[i+1][j] + d[i][j-1]  - d[i+1][j-1];
                }else{
                    d[i][j] = d[i+1][j] + d[i][j-1]  - d[i+1][j-1];
                }

            }
        }
        for (int i = 0; i < n; i++) {

            for (int k = 0; k < n; k++) {

                if(P[i][k] == true && (Math.abs(k-i+1)>1)){
                    System.out.println(org.substring(i,k+1));
                }

            }

        }
            return d[0][n-1];


    }
    public static void main(String[] args)
    {
        String str = "abaab";
        System.out.println(cntPS(str.toCharArray(),str));
    }

}
