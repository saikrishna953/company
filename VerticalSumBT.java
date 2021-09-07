package com.company;

import java.util.*;

public class VerticalSumBT {

    public static void main(String[] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Print tree");
        inorder(root);
        System.out.println("Printing vertical sums");
        printVerticalSums(root);
        System.out.println("Printing max width");
        maxwidth(root);

        Vector<Integer> v = new Vector<>();

    }

    private static void printVerticalSums(Node node) {

        int hd = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        //Map<Integer,Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        node.hd = hd;
        queue.add(node);

        while(!queue.isEmpty()){

            Node temp = queue.peek();
            hd = temp.hd;
            queue.poll();

            //map.put(hd, (Integer) temp.key);

            if (map.get(temp.hd) == null){

                ArrayList<Integer> list = new ArrayList<>();
                list.add((Integer) temp.key);
                map.put(temp.hd, list);
            }else{
                map.get(temp.hd).add((Integer) temp.key);
            }

            if (temp.left != null){
                temp.left.hd = hd -1;
                queue.add(temp.left);
            }

            if(temp.right != null){
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }

        for (Map.Entry<Integer,ArrayList<Integer>> entry: map.entrySet()) {

            int sum =0;
            for (Integer res : entry.getValue()){

                sum += res;

            }
            if(sum > 0){
                System.out.println(sum);
            }

        }
        /*for(Map.Entry<Integer,Integer> entry: map.entrySet()){

            System.out.println(entry.getValue());
        }*/
    }

    private static void inorder(Node node) {

        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);

    }

    // Function to find the maximum width of
    // the tree using level order traversal
    static int maxwidth(Node root)
    {
        // Base case
        if (root == null)
            return 0;

        // Initialize result
        int maxwidth = 0;

        // Do Level order traversal keeping
        // track of number of nodes at every level
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            // Get the size of queue when the level order
            // traversal for one level finishes
            int count = q.size();

            // Update the maximum node count value
            maxwidth = Math.max(maxwidth, count);

            // Iterate for all the nodes in
            // the queue currently
            while (count-- > 0)
            {
                // Dequeue an node from queue
                Node temp = q.remove();

                // Enqueue left and right children
                // of dequeued node
                if (temp.left != null)
                {
                    q.add(temp.left);
                }
                if (temp.right != null)
                {
                    q.add(temp.right);
                }
            }
        }
        return maxwidth;
    }

}
