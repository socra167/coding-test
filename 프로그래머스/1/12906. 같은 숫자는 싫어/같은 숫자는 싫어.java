import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (result.getLast() != arr[i]) {
                result.add(arr[i]);
            }
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}