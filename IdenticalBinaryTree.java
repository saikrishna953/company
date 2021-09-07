package com.company;

public class IdenticalBinaryTree {

    public static void main(String[] args)
    {
      
        
        Node root1,root2;

        root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        if (identicalTrees(root1, root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");

    }

    private static boolean identicalTrees(Node a, Node b) {

        if(a==null && b==null){
            return true;
        }

        if(a != null && b != null ){
            if(a.key==b.key){
                return identicalTrees(a.left,b.left) &&
                        identicalTrees(a.right,b.right);
            }
        }
        return false;

    }
}
