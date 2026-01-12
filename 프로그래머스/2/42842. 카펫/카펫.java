import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        List<List<Integer>> yellows = new ArrayList<>();
        
        for (int i = 1; i <= (yellow / 2 + 1); i++) {
            if (yellow % i == 0) {
                yellows.add(List.of(yellow / i, i));
            }
        }
        
        brown += yellow;
        for (int i = 1; i <= (brown / 2); i++) {
            if (brown % i == 0) {
                for (List<Integer> yellowa : yellows) {
                    if ((yellowa.get(0) + 1 < (brown / i)) && (yellowa.get(1) + 1 < i)) {
                        return new int[]{brown / i, i};
                    }
                }
            }
        }
        
        return answer;
    }
}