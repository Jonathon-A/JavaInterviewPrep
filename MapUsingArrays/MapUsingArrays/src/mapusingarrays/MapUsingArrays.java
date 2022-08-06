package mapusingarrays;

import java.util.ArrayList;

public class MapUsingArrays {

    public static void main(String[] args) {
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<String>();
        }
        put(1, "a");
        put(1, "a");
        put(1, "2");
        put(5, "b");
        put(2, "x");
        put(2, "s2");

        for (int i = 0; i < map.length; i++) {
            System.out.println(map[i]);
        }

        get(1);
    }

    private static void put(int key, String value) {
        if (!map[Hash(key)].contains(value)) {
            map[Hash(key)].add(value);
        }

    }

    private static int Hash(int key) {
        return Math.abs(key) % map.length;
    }

    private static void get(int key) {
       System.out.println(map[Hash(key)]);

    }

    private static final ArrayList<String>[] map = new ArrayList[4];

}
