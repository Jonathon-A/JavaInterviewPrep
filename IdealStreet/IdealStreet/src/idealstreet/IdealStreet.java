package idealstreet;

import java.util.HashMap;
import java.util.Map;

public class IdealStreet {

    public static void main(String[] args) {

        boolean[][] Blocks = {
            {
                false,
                true,
                false
            },
            {
                true,
                false,
                false
            },
            {
                true,
                true,
                false
            },
            {
                false,
                true,
                false
            },
            {
                false,
                true,
                true
            }

        };

        int[] reqs = {0, 1, 2};

        Map<Integer, Integer[]> map = new HashMap<>();
        int mincount = Blocks.length * reqs.length;
        int bestblock = 0;
        for (int i = 0; i < Blocks.length; i++) {
            int Count = 0;
            for (int j = 0; j < reqs.length; j++) {
                if (!Blocks[i][reqs[j]]) {
                    int dist = Blocks.length;
                    for (int k = i - 1; k > 0; k--) {
                        if (Blocks[k][reqs[j]]) {
                            dist = i - k;
                            break;
                        }

                    }
                    for (int k = i + 1; k < Blocks.length; k++) {
                        if (Blocks[k][reqs[j]]) {
                            if ((k - i) < dist) {
                                dist = k - i;
                            }

                            break;
                        }
                    }
                    Count += dist;
                }
            }
            System.out.println(Count);
            if (mincount > Count) {
                mincount = Count;
                bestblock = i;
            }
        }
        
        System.out.println(bestblock);

    }

}
