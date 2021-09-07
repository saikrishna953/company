package com.company;

import java.util.*;

class Test {

    static int m = 5;
    static int n = 5;

    public static void main(String[] args) {

        int grid[][] = {{'0', '1', '0', 's'},
                {'1', '0', '1', '1'},
                {'0', '1', '1', '1'},
                {'9', '1', '1', '1'}};

        //System.out.println("Minimum Distance is " + findMinDistance(grid));
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        System.out.println("Number of Islands is " + findIslands(M));

    }

    public static int findMinDistance(int[][] grid) {

        boolean[][] visited = new boolean[m][n];
        Node source = new Node(0, 0, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) visited[i][j] = true;

                if (grid[i][j] == 's') {
                    source.row = i;
                    source.col = j;
                }


            }
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()) {

            Node temp = queue.poll();

            if (grid[temp.row][temp.col] == '9') return temp.dist;

            //UP

            if (temp.row - 1 >= 0 && !visited[temp.row - 1][temp.col]) {

                queue.add(new Node(temp.row - 1, temp.col, temp.dist + 1));

                visited[temp.row - 1][temp.col] = true;
            }
            //DOWN

            if (temp.row + 1 < m && !visited[temp.row + 1][temp.col]) {

                queue.add(new Node(temp.row + 1, temp.col, temp.dist + 1));
                visited[temp.row + 1][temp.col] = true;
            }

            //LEFT

            if (temp.col - 1 >= 0 && !visited[temp.row][temp.col - 1]) {

                queue.add(new Node(temp.row, temp.col - 1, temp.dist + 1));
                visited[temp.row][temp.col - 1] = true;
            }

            //RiGHT

            if (temp.col + 1 < n && !visited[temp.row][temp.col + 1]) {

                queue.add(new Node(temp.row, temp.col + 1, temp.dist + 1));
                visited[temp.row][temp.col + 1] = true;
            }


        }

        return -1;


    }

    public static int findIslands(int[][] grid) {

        boolean[][] visited = new boolean[m][n];
        Node source = new Node(0, 0, 0);
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 && !visited[i][j]){
                    traverse(grid,visited,i,j);
                    count++;
                }
            }
        }

       return count;

    }

    private static void traverse(int[][] grid, boolean[][] visited, int i, int j) {

        Queue<Node> queue = new LinkedList<>();
        Node source = new Node(i,j,0);
        queue.add(source);
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            //UP

            if (temp.row - 1 >= 0 && (grid[temp.row - 1][temp.col] == 1) &&!visited[temp.row - 1][temp.col]) {

                queue.add(new Node(temp.row - 1, temp.col, temp.dist + 1));
                visited[temp.row - 1][temp.col] = true;
                traverse(grid,visited,temp.row -1, temp.col);
            }
            //DOWN

            if (temp.row + 1 < m && (grid[temp.row + 1][temp.col] == 1) && !visited[temp.row + 1][temp.col]) {

                queue.add(new Node(temp.row + 1, temp.col, temp.dist + 1));
                visited[temp.row + 1][temp.col] = true;
                traverse(grid,visited,temp.row + 1, temp.col);
            }

            //LEFT

            if (temp.col - 1 >= 0 && (grid[temp.row][temp.col - 1] == 1) && !visited[temp.row][temp.col - 1]) {

                queue.add(new Node(temp.row, temp.col - 1, temp.dist + 1));
                visited[temp.row][temp.col - 1] = true;
                traverse(grid,visited,temp.row, temp.col - 1);
            }

            //RiGHT

            if (temp.col + 1 < n && (grid[temp.row][temp.col + 1] == 1) && !visited[temp.row][temp.col + 1]) {

                queue.add(new Node(temp.row, temp.col + 1, temp.dist + 1));
                visited[temp.row][temp.col + 1] = true;
                traverse(grid,visited,temp.row, temp.col + 1);
            }


        }

    }

    static class Node {

        int row;
        int col;
        int dist;

        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;

        }


    }

}
