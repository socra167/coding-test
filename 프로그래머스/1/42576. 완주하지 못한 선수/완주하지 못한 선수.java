import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> runners = new HashMap<>();
        
        for (String runner : participant) {
            if (runners.keySet().contains(runner)) {
                runners.put(runner, runners.get(runner) + 1);
            } else {
                runners.put(runner, 0);   
            }
        }
        
        for (String completedRunner : completion) {
            if (runners.keySet().contains(completedRunner)) {
                if (runners.get(completedRunner) == 0) {
                    runners.remove(completedRunner);
                } else {
                    runners.put(completedRunner, runners.get(completedRunner) - 1);
                }
            }
        }
        
        return runners.keySet().stream()
            .findFirst()
            .orElseThrow(() -> new RuntimeException("완주하지 못한 선수가 없습니다."));
    }
}