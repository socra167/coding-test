import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(new Long(scoville[i]));
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            if (K <= queue.peek()) {
                return count;
            }
            count++;
            Long food1 = queue.poll();
            Long food2 = queue.poll();
            
            if (food1 == null || food2 == null) {
                return -1;
            }
            queue.add(food1 + food2 * 2);
        }
        
        return -1;
    }
}