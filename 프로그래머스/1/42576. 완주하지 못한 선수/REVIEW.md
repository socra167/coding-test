#Coding-Test 

---

# 완주하지 못한 선수

### 접근
문제 풀이 방식 자체는 단순하다.
전체 참가자 `participant`에서 완주한 사람 `completion` 을 제외하면 결과를 얻을 수 있다.

하지만 해시를 사용하지 않으면 효율성 테스트를 통과할 수 없다.
문제 조건에 동명이인이 있기 때문에 `HashSet`은 사용할 수 없어 `HashMap`을 사용했다.

key - value로 `이름` - `참가수`를 저장하고, 완주자 `completion`를 순회하면서 참가수를 감소 시켰다.
만약 참가수가 0이되면 해당 키를 제거했다.

### 알게된 내용
나는 `if (runners.keySet().(runner))` 로 HashMap에 해당 키가 존재하는지 검사하고 카운트해줬는데
다른 사람들의 풀이를 보니 `HashMap.getOrDefault()`를 사용해 검사를 간결하게 사용하는 방법이 있었다.

처음 `participant`를 순회하며 저장하는 부분에 적용해서 코드를 간결하게 만들 수 있을 것 같다.
`completion`을 순회하며 감소시킬 때 나는 0이 되면 키를 제거했는데 이 부분도 getOrDefault()로 간소화하려면 키를 제거하지 않고, 결과를 얻을 때 `(value >= 0)` 등의 조건으로 얻으면 가능하다.

### 풀이
```java
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
```
