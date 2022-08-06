package undirectedgraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class UndirectedGraph {

    public static void main(String[] args) {
        //Convert edges list to adjecency matrix
        String[][] edges = {
            {"i", "j"},
            {"k", "i"},
            {"m", "k"},
            {"k", "l"},
            {"o", "n"},
            {"1", "2"}
        };

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map.get(edges[i][0]) == null) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(edges[i][1]);
                map.put(edges[i][0], newList);

            } else {
                map.get(edges[i][0]).add(edges[i][1]);
            }

            if (map.get(edges[i][1]) == null) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(edges[i][0]);
                map.put(edges[i][1], newList);
            } else {
                map.get(edges[i][1]).add(edges[i][0]);
            }
        }
        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(IsPathDFS(map, "l", "j"));

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(NumberOfConnectedComponents(map));

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(LargestConnectedComponent(map));//5

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(new UndirectedGraph().ShortestPathBFS(map, "j", "l"));

        Map<String, ArrayList<String>> map2 = new HashMap<>();
        map2.put("0", new ArrayList<>());
        map2.get("0").add("8");
        map2.get("0").add("1");
        map2.get("0").add("5");
        map2.put("1", new ArrayList<>());
        map2.get("1").add("0");
        map2.put("5", new ArrayList<>());
        map2.get("5").add("0");
        map2.get("5").add("8");
        map2.put("8", new ArrayList<>());
        map2.get("8").add("0");
        map2.get("8").add("5");
        map2.put("2", new ArrayList<>());
        map2.get("2").add("3");
        map2.get("2").add("4");
        map2.put("3", new ArrayList<>());
        map2.get("3").add("2");
        map2.get("3").add("4");
        map2.put("4", new ArrayList<>());
        map2.get("4").add("3");
        map2.get("4").add("2");

        Visited = new HashMap<>();
        
        stack = new Stack<>();
        System.out.println(IsPathDFS(map2, "1", "5"));

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(NumberOfConnectedComponents(map2));

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(LargestConnectedComponent(map2));//5

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(new UndirectedGraph().ShortestPathBFS(map2, "4", "8"));

        String[][] edges2 = {
            {"w", "x"},
            {"x", "y"},
            {"z", "y"},
            {"z", "v"},
            {"w", "v"}
        };

        Map<String, ArrayList<String>> map3 = new HashMap<>();
        for (int i = 0; i < edges2.length; i++) {
            if (map3.get(edges2[i][0]) == null) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(edges2[i][1]);
                map3.put(edges2[i][0], newList);

            } else {
                map3.get(edges2[i][0]).add(edges2[i][1]);
            }

            if (map3.get(edges2[i][1]) == null) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(edges2[i][0]);
                map3.put(edges2[i][1], newList);
            } else {
                map3.get(edges2[i][1]).add(edges2[i][0]);
            }
        }

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(IsPathDFS(map3, "w", "z"));

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(NumberOfConnectedComponents(map3));

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(LargestConnectedComponent(map3));//5

        Visited = new HashMap<>();
        stack = new Stack<>();
        System.out.println(new UndirectedGraph().ShortestPathBFS(map3, "w", "z"));//5

    }
    private static Map<String, Integer> Visited = new HashMap<>();

    private static Stack<String> stack = new Stack<>();

    private static boolean IsPathDFS(Map<String, ArrayList<String>> map, String Start, String End) {
        stack.push(Start);

        while (!stack.isEmpty()) {
            String CurrentNode = stack.pop();
            if (CurrentNode.equals(End)) {
                return true;
            }
            Visited.put(CurrentNode, 0);
            if (map.get(CurrentNode) == null) {
                return false;
            }
            ArrayList<String> next = map.get(CurrentNode);
            for (int i = 0; i < next.size(); i++) {
                if (Visited.get(next.get(i)) == null) {
                    stack.push(next.get(i));
                }
            }
        }
        return false;

    }

    private static int NumberOfConnectedComponents(Map<String, ArrayList<String>> map) {

        int count = 0;
        Object[] nodes = map.keySet().toArray();
        for (int j = 0; j < nodes.length; j++) {
            String NextNode = String.valueOf(nodes[j]);
            stack.push(NextNode);

            if (Visited.get(NextNode) == null) {
                count++;
            }

            while (!stack.isEmpty()) {
                String CurrentNode = stack.pop();

                Visited.put(CurrentNode, 0);

                ArrayList<String> next = map.get(CurrentNode);
                for (int i = 0; i < next.size(); i++) {
                    if (Visited.get(next.get(i)) == null) {
                        stack.push(next.get(i));
                    }
                }
            }

        }

        return count;
    }

    private static int LargestConnectedComponent(Map<String, ArrayList<String>> map) {
        int maxCount = 0;

        Object[] nodes = map.keySet().toArray();
        for (int j = 0; j < nodes.length; j++) {
            int count = 1;
            String NextNode = String.valueOf(nodes[j]);
            stack.push(NextNode);

            while (!stack.isEmpty()) {
                String CurrentNode = stack.pop();

                Visited.put(CurrentNode, 0);

                ArrayList<String> next = map.get(CurrentNode);
                for (int i = 0; i < next.size(); i++) {
                    if (Visited.get(next.get(i)) == null) {
                        count++;
                        stack.push(next.get(i));
                    }
                }

            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    Queue<queueItem> queue = new ArrayDeque<>();

    private int ShortestPathBFS(Map<String, ArrayList<String>> map, String start, String End) {

        queue.add(new queueItem(start, 0));

        while (!queue.isEmpty()) {
            queueItem Next = queue.poll();
            String nextNode = Next.node;

            int distance = Next.distance;
            if (nextNode.equals(End)) {
                return distance;
            }
            Visited.put(nextNode, 0);
            ArrayList<String> NexNodes = map.get(nextNode);

            for (int i = 0; i < NexNodes.size(); i++) {

                if (Visited.get(NexNodes.get(i)) == null) {
                    queue.add(new queueItem(NexNodes.get(i), distance + 1));
                }

            }

        }
        return -1;

    }

}

class queueItem {

    public String node;
    public int distance;

    public queueItem(String node, int distance) {
        this.node = node;
        this.distance = distance;
    }

}
