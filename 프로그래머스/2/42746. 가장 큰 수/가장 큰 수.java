import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
            .boxed()
            .map(String::valueOf)
            .sorted((s1, s2) -> (s2.concat(s1)).compareTo(s1.concat(s2)))
            .collect(Collectors.joining());
        return result.charAt(0) == '0' ? "0" : result;
    }
}