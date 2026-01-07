import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Process> deque = new ArrayDeque<>(priorities.length);
        for (int i = 0; i < priorities.length; i++) {
            deque.offer(new Process(priorities[i], location == i));
        }
        
        List<Integer> list = Arrays.stream(priorities)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        int size = deque.size(); 
        int count = 0;
        while(0 < size) {
            Process p = deque.poll();
            if (p.getPriority() == list.get(0)) {
                size--;
                if (p.isTarget()) {
                    return count + 1;
                }
                count++;
                list.remove(0);
            } else {
                deque.offer(p);
            }
        }
        
        return 0;
    }
    
    static class Process {
        private int priority;
        private boolean target;
        
        public Process(int priority, boolean target) {
            this.priority = priority;
            this.target = target;
        }
        
        public int getPriority() {
            return priority;
        }
        
        public boolean isTarget() {
            return target;
        }
    }
}