import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> result = new ArrayList<>();
        int last = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (last != arr[i]) {
                last = arr[i];
                result.add(last);
            }
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}