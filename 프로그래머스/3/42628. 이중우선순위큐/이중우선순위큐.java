import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> counter = new HashMap<>();

        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                int num = Integer.parseInt(operation.substring(2));
                minQ.offer(num);
                maxQ.offer(num);
                counter.put(num, counter.getOrDefault(num, 0) + 1);
            } else if (operation.equals("D 1")) {
                remove(maxQ, counter);
            } else if (operation.equals("D -1")) {
                remove(minQ, counter);
            }
        }

        clean(minQ, counter);
        clean(maxQ, counter);

        if (counter.isEmpty()) return new int[]{0, 0};

        int max = maxQ.peek();
        int min = minQ.peek();

        return new int[]{max, min};
    }

    private void remove(PriorityQueue<Integer> q, Map<Integer, Integer> counter) {
        while (!q.isEmpty()) {
            int val = q.poll();
            if (counter.containsKey(val)) {
                int count = counter.get(val);
                if (count == 1) counter.remove(val);
                else counter.put(val, count - 1);
                break;
            }
        }
    }

    private void clean(PriorityQueue<Integer> q, Map<Integer, Integer> counter) {
        while (!q.isEmpty() && !counter.containsKey(q.peek())) {
            q.poll();
        }
    }
}
