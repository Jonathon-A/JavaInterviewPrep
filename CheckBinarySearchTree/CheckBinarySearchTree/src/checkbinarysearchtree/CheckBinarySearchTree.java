package checkbinarysearchtree;

public class CheckBinarySearchTree {

    public static void main(String[] args) {
        Node a = new Node(50);
        Node b = new Node(10);
        Node c = new Node(80);
        Node d = new Node(5);
        Node e = new Node(30);
        Node f = new Node(70);
        Node g = new Node(90);
        Node h = new Node(20);
        Node i = new Node(40);
        Node j = new Node(85);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;
        g.left = j;

        System.out.println(CheckBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    private static boolean CheckBST(Node root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return CheckBST(root.left, min, root.val) && CheckBST(root.right, root.val, max);
    }

}
