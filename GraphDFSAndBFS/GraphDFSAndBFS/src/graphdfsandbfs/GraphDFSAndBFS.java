package graphdfsandbfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphDFSAndBFS {

    public static void main(String[] args) {

        Map<String, String[]> Graph = new HashMap<>();
        Graph.put("a", new String[]{"b", "c"});
        Graph.put("b", new String[]{"d"});
        Graph.put("c", new String[]{"e"});
        Graph.put("d", new String[]{"f"});
        Graph.put("e", new String[]{});
        Graph.put("f", new String[]{});

        stack = new Stack<>();

        DFSGraph(Graph, "a");

        System.out.println("");

        stack = new Stack<>();

        DFSGraphRecursively(Graph, "a");

        System.out.println("");

        queue = new ArrayDeque<>();

        BFSGraph(Graph, "a");

        System.out.println("");

        stack = new Stack<>();

        System.out.println(IsPath(Graph, "a", "f"));

    }

    private static boolean IsPath(Map<String, String[]> Graph, String StartNode, String TargetNode) {
        stack.push(StartNode);

        while (!stack.isEmpty()) {
            String CurrentNode = stack.pop();
            if (CurrentNode.equals(TargetNode)) {
                return true;
            }
            String[] Neighbours = Graph.get(CurrentNode);
            for (int i = 0; i < Neighbours.length; i++) {
                stack.push(Neighbours[i]);
            }
        }
        return false;
    }

    private static Stack<String> stack = new Stack<>();

    private static void DFSGraph(Map<String, String[]> Graph, String Node) {

        //add root to stack
        //pop stack for current node
        //print current node
        //add all of current nodes neighbors to stack (get them from map)
        //loop while stack is not empty
        stack.push(Node);

        while (!stack.isEmpty()) {

            String CurrentNode = stack.pop();
            System.out.println(CurrentNode);
            String[] Neighbours = Graph.get(CurrentNode);
            for (int i = 0; i < Neighbours.length; i++) {
                stack.push(Neighbours[i]);
            }
        }
    }

    private static void DFSGraphRecursively(Map<String, String[]> Graph, String Node) {

        stack.push(Node);

        while (!stack.isEmpty()) {

            String CurrentNode = stack.pop();
            System.out.println(CurrentNode);
            String[] Neighbours = Graph.get(CurrentNode);
            for (int i = 0; i < Neighbours.length; i++) {
                DFSGraphRecursively(Graph, Neighbours[i]);
            }
        }
    }

    private static Queue<String> queue = new ArrayDeque<>();

    private static void BFSGraph(Map<String, String[]> Graph, String Node) {

        //add root to queue
        //poll queue for current node
        //print current node
        //add all of current nodes neighbors to queue (get them from map)
        //loop queue stack is not empty
        queue.add(Node);

        while (!queue.isEmpty()) {
            String CurrentNode = queue.poll();
            System.out.println(CurrentNode);
            String[] Neighbours = Graph.get(CurrentNode);
            for (int i = 0; i < Neighbours.length; i++) {
                queue.add(Neighbours[i]);
            }
        }
    }

}
