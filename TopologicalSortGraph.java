package com.company;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSortGraph {

    static int V = 6;

    public static void main(String[] args){

        Graph g = new Graph(6);
        g.addEdge(g,5, 2);
        g.addEdge(g,5, 0);
        g.addEdge(g,4, 0);
        g.addEdge(g,4, 1);
        g.addEdge(g,2, 3);
        g.addEdge(g,3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        topologicalSort(g);

    }

    private static void topologicalSort(Graph g) {

        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V ; i++) {
            if (visited[i] == false)
                topologicalSortUtil(g,stack,i,visited);
        }

        while(!stack.empty()){
            System.out.println(stack.pop());
        }


    }

    private static void topologicalSortUtil(Graph g, Stack<Integer> stack, int i, boolean[] visited) {

        visited[i] = true;
        Iterator<Integer> it = g.adjArrayList[i].listIterator();
        while(it.hasNext()){
            int r = it.next();
            while(!visited[r]){
                visited[r] = true;
                topologicalSortUtil(g,stack,r,visited);
            }
        }
        stack.push(i);
    }


}
