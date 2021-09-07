package com.company;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Practise {

    public static void main(String[] args) {

        Node node = new Node(50);
        node.left = new Node(30);
        node.right = new Node(70);
        node.left.left = new Node(20);
        node.left.right = new Node(40);
        node.right.left = new Node(60);
        //node.right.right = new Node(80);

        inorder(node);

        Node clonetree = cloneTree(node);
        System.out.println("Cloned tree:");
        inorder(clonetree);
        Practise pc = new Practise();
        //System.out.println(pc.height(node));

        System.out.println("Mirrored tree:");

        //deleteBST(int 20);

        //delete(node,16);

        //inorder(node);

        System.out.println("wewe" + findLastelement(node));
        int[] sai = {12, 11, 1, 3, 4, 5};
        Arrays.sort(sai, 2, sai.length - 1);
        System.out.println(sai[0]);

        StringBuffer sb = new StringBuffer();
        sb.append("sai");
        sb.reverse();
        System.out.println(sb);
        String ss = "silent";
        String ss1 = "listen";

        //String[] arr = ss.split(" ");
        //System.out.println(arr[0].charAt(0));

        char[] carr = ss.toCharArray();
        char[] carr1 = ss1.toCharArray();

        Arrays.sort(carr);
        Arrays.sort(carr1);
        for (int i = 0; i < carr.length - 1; i++) {
            if (carr[i] != carr1[i]) {
                System.out.println("Not Anagram");
            }
        }
        System.out.println("Yes Anagram");

        String input = "{())}";
        char[] chararr = input.toCharArray();

        System.out.println(isParanthesisBalanced(chararr));

        Graph graph = new Graph(5);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        printGraph(graph);

        BFS(2, graph);
        DFS(3,graph);

        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,Integer> sf = new HashMap<>();
        hs.add(2);
        hs.add(2);
        System.out.println(Math.abs(2-3));
        int a = Math.abs(2-3);

        Instant in = Instant.now();
        System.out.println(in);
        System.out.println(System.currentTimeMillis());
        System.out.println("inorderbst");
        pc.root1= node;
        pc.insertBSTTRee(2);
        inorder(pc.root1);

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //List<Integer> list1 = list.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList()).toString());
        System.out.println("Size: "+ list.size());


        Employee e1 = new Employee();
        Employee e2 = new Employee();
        e1.id = 12;
        e1.name = "sai";
        e2.id = 2;
        e2.name = "kri";

        Employee emparr[] =  new Employee[]{e1,e2};
        Arrays.sort(emparr,Employee.employeeidCompare);
        System.out.println(emparr[0].id);
        Arrays.copyOf(list.toArray(),list.size());
        LinkedList<Integer> ll = new LinkedList<>();

        int s = 134;
        System.out.println("% is " + 134%10);
        System.out.println("/ is " + 134/10);



    }
    Node root1;

    private static Node insertBST(int i, Node node) {

        if (node == null){
            node = new Node(i);
            return node;
        }
        if ((int)node.key < i){
             node.left = insertBST(i,node.left);
        }
        if ((int)node.key > i){
            node.right = insertBST(i,node.left);
        }
        return node;
    }

    void insertBSTTRee(int i){
        root1 = insertBST(i,root1);
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        } else {

            /* compute the depth of each subtree */
            int lDepth = height(node.left);
            int rDepth = height(node.right);

            /* use the larger one */
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }
    private static Node cloneTree(Node node) {

        if(node == null){
            return node;
        }
        Node root = new Node(node.key);
        root.left = cloneTree(node.left);
        root.right = cloneTree(node.right);
        return root;
    }

    static void mirror(Node node)
    {
        if(node == null)
            return ;
        else
        {
            Node temp;

            mirror(node.left);
            mirror(node.right);

            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }


    private static void BFS(int i, Graph graph) {

        boolean[] visited = new boolean[graph.V];

        visited[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int s = queue.poll();
            System.out.println(s);
            Iterator<Integer> iter = graph.adjArray[s].listIterator();
            while (iter.hasNext()) {
                int n = iter.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    private static void DFS(int i, Graph graph) {

        boolean[] visited = new boolean[graph.V];

        DFSUtil(i, graph, visited);
    }

    private static void DFSUtil(int i, Graph graph, boolean[] visited) {

        visited[i] = true;

        System.out.println(i);
        Iterator<Integer> iter = graph.adjArray[i].listIterator();
        while (iter.hasNext()) {
            int n = iter.next();
            if (!visited[n]) {
                DFSUtil(n,graph,visited );
            }
        }

    }

    private static void printGraph(Graph graph) {

        for (int i = 0; i < graph.V; i++) {

            Iterator<Integer> ff = graph.adjArray[i].listIterator();
            while (ff.hasNext()) {
                System.out.println(i + "->" + ff.next());
            }
            /*for (int j = 0; j < graph.adjArray[i].size(); j++) {
                System.out.println(i+ "->" + graph.adjArray[i].get(j) );
            }*/

        }
    }

    private static void addEdge(Graph graph, int i, int i1) {

        graph.adjArray[i].add(i1);
        graph.adjArray[i1].add(i);

    }

    private static boolean isParanthesisBalanced(char[] chararr) {

        Stack<Character> stack = new Stack();
        for (int i = 0; i < chararr.length; i++) {
            if (chararr[i] == '(' || chararr[i] == '[' || chararr[i] == '{') {
                stack.push(chararr[i]);
            }
            if (chararr[i] == ')' || chararr[i] == ']' || chararr[i] == '}') {

                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatchingPair(chararr[i], stack.pop())) {
                    return false;
                }

            }

        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isMatchingPair(char c, Character pop) {

        if (c == ')' && pop == '(') {
            return true;
        } else if (c == '[' && pop == ']') {
            return true;
        } else if (c == '}' && pop == '{') {
            return true;
        }
        return false;
    }

   /* public static void deleteBST(Node node, Integer key){
        node = deleteRec(node,key);
    }*/

    //private static Node<Integer> deleteRec(Node node, Integer key){


    //}

    private static void inorder(Node node) {

        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    private static void delete(Node node, Integer value) {


        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.poll();

            if (temp.key == value) {
                Integer last = 0;
                //findLastelement(node,last);
                temp.key = last;
                break;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    private static Integer findLastelement(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Integer result = null;
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.poll();

            if (temp.right != null) {
                queue.add(temp.right);
            } else {
                result = (Integer) temp.key;
                break;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            } else {
                result = (Integer) temp.key;
                break;
            }


        }

        return result;


    }

    static class Graph {

        int V;
        LinkedList<Integer> adjArray[];

        Graph(int V) {
            this.V = V;
            adjArray = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adjArray[i] = new LinkedList<>();
            }

        }

    }


}
