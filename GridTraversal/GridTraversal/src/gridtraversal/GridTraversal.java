package gridtraversal;

import java.util.HashMap;
import java.util.Map;

public class GridTraversal {

    public static void main(String[] args) {
        System.out.println(TraverseGrid(100, 100));
    }
    private static final Map<String, Long> map = new HashMap<>();

    private static long TraverseGrid(int x, int y) {

        if (x == 0 || y == 0) {
            return 0;
        }

        if (x == 1 && y == 1) {
            return 1;
        }
        long ways;
        String key = x + "," + y;
        String key2 = y + "," + x;
        if (map.get(key) != null) {
            ways = map.get(key);

        } else if (map.get(key2) != null) {
            ways = map.get(key2);

        } else {
            ways = TraverseGrid(x - 1, y) + TraverseGrid(x, y - 1);
        }
        map.put(key, ways);
        map.put(key2, ways);

        return ways;
    }

}
