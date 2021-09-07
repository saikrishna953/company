package com.company;

public class GraphMain {

    public static void main(String[] args){

        Graph graph = new Graph(5);
        Graph.addEdge(graph,0, 1);
        Graph.addEdge(graph,0, 2);
        Graph.addEdge(graph,1, 2);
        Graph.addEdge(graph,2, 0);
        Graph.addEdge(graph,2, 3);
        Graph.addEdge(graph,3, 3);

        graph.BFS(2);

        int grid[][] = { { '0', '1', '0', 's' },
            { '1', '0', '1', '1' },
            { '0', '1', '1', '1' },
            { '9', '1', '1', '1' } };

        System.out.print(graph.minDistance(grid));

    }
}
