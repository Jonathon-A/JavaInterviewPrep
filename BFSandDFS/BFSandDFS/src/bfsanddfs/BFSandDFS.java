package bfsanddfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSandDFS {

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node h = new Node("h");
        Node i = new Node("i");
        Node j = new Node("j");
        Node k = new Node("k");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        e.left = i;
        e.right = j;
        g.right = k;

        BFS(a);

        DFS(a);
        /*
      
            a
           / \
          /   \
         /     \   
        b       c
       / \     / \
      /   \   /   \
     d     e f     g
    /     / \       \
   h     i   j       k
      
         */

    }

    private static void BFS(Node Root) {
        int[] a = new int[2];
        a[0] = 1;
        System.out.println(a[0]);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(Root);
        while (!queue.isEmpty()) {
            Root = queue.poll();
            System.out.print(Root.val + " ");
            if (Root.left != null) {
                queue.add(Root.left);
            }
            if (Root.right != null) {
                queue.add(Root.right);
            }

        }
        System.out.println("");

    }

    private static void DFS(Node Root) {
        if (Root != null) {
            System.out.print(Root.val + " ");
            DFS(Root.left);
            DFS(Root.right);
        }
    }

}
