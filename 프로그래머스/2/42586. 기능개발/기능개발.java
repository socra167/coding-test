import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        List<Integer> left = new ArrayList<>(); 
        
        for (int i = 0; i < progresses.length; i++) {
            left.add((int) (Math.ceil((100 - progresses[i]) / (double) speeds[i])));
        }
        
        int max = left.get(0);
        int featCount = 1;
        for (int i = 1; i < left.size(); i++) {
            if (max < left.get(i)) {
                result.add(featCount);
                max = left.get(i);
                featCount = 0;
            }
            featCount++;
        }
        result.add(featCount);
        
        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}