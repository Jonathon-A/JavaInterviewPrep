package reverselinkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        //a -> b -> c -> d -> null
        Node d = new Node("d", null);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);
        System.out.println("");
        PrintLinkedList(a);

        ReverseLikedList(a);
        
        System.out.println("");
        PrintLinkedList(d);
        
        ReverseLikedListIteratively(d);
        
        System.out.println("");
        PrintLinkedList(a);
    }

    private static void ReverseLikedList(Node Head) {

        ReverseLikedListRecursively(Head, null);
    }

    private static void ReverseLikedListRecursively(Node Head, Node Previous) {
        if (Head.next != null) {
            ReverseLikedListRecursively(Head.next, Head);
        }
        Head.next = Previous;

    }

    private static void ReverseLikedListIteratively(Node Head) {

        Node Current = Head;
        Node Prev = null;
        while (Current != null) {

            Node Next = Current.next;

            Current.next = Prev;

            Prev = Current;

            Current = Next;

        }
    }

    private static void PrintLinkedList(Node Head) {

        System.out.print(Head.value + " ");
        if (Head.next != null) {
            System.out.println(Head.next.value);
            PrintLinkedList(Head.next);
        } else {
            System.out.println("null");
        }

    }
}
