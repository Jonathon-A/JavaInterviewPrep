
package autocompletion;

import com.sun.javafx.collections.MappingChange.Map;
import java.util.HashMap;

public class Node {
    Map<Character, Node> map;
    boolean isCompleteWord;

    public Node(Map<Character, Node> map, boolean isCompleteWord) {
    //    this.map = new HashMap<>();
        this.isCompleteWord = isCompleteWord;
        
    }
    // 1 2 1 2 1 2
    // 2 2 2 2 1 2
    // 1 2 2 2 1 2

}
