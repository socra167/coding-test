import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();
        
        for (int[] command : commands) {
            result.add(Arrays.stream(array)
                .skip(command[0] - 1)
                .limit(command[1] - command[0] + 1)
                .sorted()
                .skip(command[2] - 1)
                .findFirst()
                .orElse(-1));
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}