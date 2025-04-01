import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int[] sortedCitations = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i)
            .toArray();
        
        int max = 0;
        for (int i = 0; i < sortedCitations.length; i++) {
            int currentMax = Math.min(i + 1, sortedCitations[i]);
            if (max < currentMax) {
                max = currentMax;
            }
        }
        
        return max;
    }
}