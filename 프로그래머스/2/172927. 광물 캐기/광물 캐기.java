import java.util.*;

class Solution {
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        Integer[][] costs = new Integer[(int)(Math.ceil(minerals.length / 5.0))][3];

        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(costs[i], 0);
        }

        Map<String, Integer[]> mineralCost = new HashMap<>();

        mineralCost.put("diamond", new Integer[]{1, 5, 25});
        mineralCost.put("iron", new Integer[]{1, 1, 5});
        mineralCost.put("stone", new Integer[]{1, 1, 1});

        for (int i = 0; i < minerals.length; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i / 5][j] += mineralCost.get(minerals[i])[j];
            }
        }

        if (picks[0] + picks[1] + picks[2] < costs.length) {
            for (int i = 0; i < costs.length - (picks[0] + picks[1] + picks[2]); i++) {
                Arrays.fill(costs[costs.length - 1 - i], 0);
            }
        }

        Arrays.sort(costs, (o1, o2) -> o2[2] - o1[2]);

        for (Integer[] cost : costs) {
            for (int i = 0; i < picks.length; i++) {
                if (0 < picks[i]) {
                    picks[i]--;
                    answer += cost[i];
                    break;
                }
            }
        }
        
        return answer;
    }
}