#Coding-Test 

---

# K번째수

### 접근
문제에서 주어진 동작들이 모두 Stream 메서드로 구현되어 있어 Stream으로  간단하게 풀 수 있다.

다른 메서드로 푸는 방법도 있지만 Stream이 가독성 측면에서 더 나은 것 같다.

### 알게된 내용
**`Arrays.copyOfRange()`**

- 배열의 일부분을 복사하여 새로운 배열을 생성한다.

```
  int[] newArray = Arrays.copyOfRange(originalArray, fromIndex, toIndex);
```

`Arrays.copyOfRange()`로 배열의 특정 부분을 복사해 풀이한 풀이가 많았다. 사용해본 적 없는 메서드인데 배열을 다룰 때 유용할 것 같다.

### 풀이
```java
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
```
