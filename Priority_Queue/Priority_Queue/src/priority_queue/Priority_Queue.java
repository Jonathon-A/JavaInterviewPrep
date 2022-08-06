
package priority_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class Priority_Queue {

    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());

        pq.add("ab");
        pq.add("abb");
        pq.add("a");
        
         pq2.add(1);
        pq2.add(2);
        pq2.add(3);
        
        
      
        System.out.println((pq.poll()));
        System.out.println((pq.poll()));
        System.out.println((pq.poll()));
        System.out.println((pq2.poll()));
        System.out.println((pq2.poll()));

    }

}
