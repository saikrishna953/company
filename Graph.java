package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    int V;
    LinkedList<Integer> adjArrayList[];

    Graph(int V){
        this.V = V;

        adjArrayList = new LinkedList[V];

        for(int i = 0; i < V ; i++){
            adjArrayList[i] = new LinkedList<>();
        }



    }

    static void addEdge(Graph graph, int src, int dest)
    {
        // Add an edge from src to dest.
        graph.adjArrayList[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        //graph.adjArrayList[dest].add(src);
    }

    void BFS(int s){

        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjArrayList[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }

    int minDistance(int grid[][])
    {
        Node source = new Node(0,0,0);

        // To keep track of visited QItems. Marking
        // blocked cells as visited.
        boolean visited[][] = new boolean[grid.length][grid.length];
        for (int i = 0; i < (grid.length); i++) {
            for (int j = 0; j < (grid.length); j++)
            {
                if (grid[i][j] == '0')
                    visited[i][j] = true;
                else
                    visited[i][j] = false;

                // Finding source
                if (grid[i][j] == 's')
                {
                    source.row = i;
                    source.col = j;
                }
            }
        }

        // applying BFS on matrix cells starting from source
        Queue<Node> q = new LinkedList<>();
        q.add(source);
        visited[source.row][source.col] = true;
        while (!q.isEmpty()) {
            Node p = q.peek();
            q.poll();

            // Destination found;
            if (grid[p.row][p.col] == '9')
                return p.dist;

            // moving up
            if (p.row - 1 >= 0 &&
                    !visited[p.row - 1][p.col]) {
                q.add(new Node(p.row - 1, p.col, p.dist + 1));
                visited[p.row - 1][p.col] = true;
            }

            // moving down
            if (p.row + 1 < (grid.length) &&
                    !visited[p.row + 1][p.col]) {
                q.add(new Node(p.row + 1, p.col, p.dist + 1));
                visited[p.row + 1][p.col] = true;
            }

            // moving left
            if (p.col - 1 >= 0 &&
                    !visited[p.row][p.col - 1]) {
                q.add(new Node(p.row, p.col - 1, p.dist + 1));
                visited[p.row][p.col - 1] = true;
            }

            // moving right
            if (p.col + 1 < (grid.length) &&
                    !visited[p.row][p.col + 1]) {
                q.add(new Node(p.row, p.col + 1, p.dist + 1));
                visited[p.row][p.col + 1] = true;
            }
        }
        return -1;
    }

    class Node{
        int row;
        int col;
        int dist;

        Node(int row,int col, int dist){
            this.row = row;
            this.col = col;
            this. dist = dist;
        }
    }


}
