import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int current = 0; // 현재 담은 귤의 수
        int answer = 0;
        
        // [귤의 크기 : 귤의 수] Map으로 전환
        Map<Integer, Long> count = Arrays.stream(tangerine)
            .boxed()
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        
        // 귤의 수 내림차순으로 정렬
        List<Integer> keys = new ArrayList<>(count.keySet());
        keys.sort((o1, o2) -> count.get(o2).compareTo(count.get(o1)));
        
        // 수가 많은 귤부터 담기
        for (int i : keys) {
            if (k <= current) {
                break;
            }
            answer++;
            current += count.get(i);
        }
        
        return answer;
    }
}