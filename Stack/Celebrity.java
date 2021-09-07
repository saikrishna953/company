package com.company.Stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Celebrity {


    public int getID(int[][] M, int N){

        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<N;i++){
            stack.push(i);
        }

        while(stack.size() > 1){

            int a =stack.pop();
            int b = stack.pop();
            if(M[a][b] == 1){
                stack.push(b);
            }else{
                stack.push(a);
            }

        }
        int c = stack.pop();
        for(int i = 0;i<N;i++){
            if((i!=c) && (M[c][i]==1 || (!(M[i][c] ==1)))){
                return -1;
            }
        }

        return c;
    }
}
