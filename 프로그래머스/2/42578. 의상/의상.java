import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // HashMap에 의상 종류별 개수를 저장
        Map<String, Integer> clothCounts = new HashMap<>();
        for (String[] cloth : clothes) {
            clothCounts.put(cloth[1], clothCounts.getOrDefault(cloth[1], 0) + 1);
        }

        // 가능한 조합의 수 계산
        List<Integer> clothTypeCount = new ArrayList<>(clothCounts.values());
        int result = 1;
        for (int count : clothTypeCount) {
            result *= (count + 1);
        }
        
        return result - 1;
    }
}
