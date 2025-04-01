import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        int[] sortedCitations = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i)
            .toArray();
        
        for (int i = 0; i < sortedCitations.length; i++) {
            if (sortedCitations[i] < i) {
                return i;
            }
            if (sortedCitations[i] < (i + 2)) {
                return sortedCitations[i];
            }
        }
        return sortedCitations.length < sortedCitations[sortedCitations.length - 1] ?
                    sortedCitations.length : 0;
    }
}