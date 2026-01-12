import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<List<Integer>> yellowFactors = new ArrayList<>();
        
        for (int i = 1; i <= (yellow / 2 + 1); i++) {
            if (yellow % i == 0) {
                yellowFactors.add(List.of(yellow / i, i));
            }
        }
        
        brown += yellow;
        for (int i = 1; i <= (brown / 2); i++) {
            if (brown % i == 0) {
                for (List<Integer> yellowFactor : yellowFactors) {
                    if ((yellowFactor.get(0) + 1 < (brown / i)) && (yellowFactor.get(1) + 1 < i)) {
                        return new int[]{brown / i, i};
                    }
                }
            }
        }
        
        return new int[]{};
    }
}