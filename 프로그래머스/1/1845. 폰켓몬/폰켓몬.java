import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int selectableCount = nums.length / 2;
        Set<Integer> ponkemonKind = new HashSet<>();
        for (int num : nums) {
            ponkemonKind.add(num);
        }
        if (selectableCount < ponkemonKind.size()) {
            return selectableCount;
        }
        return ponkemonKind.size();
    }
}