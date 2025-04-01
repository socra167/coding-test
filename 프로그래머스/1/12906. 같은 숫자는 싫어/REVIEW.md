#Coding-Test 

---

# 같은 숫자는 싫어

### 접근
큐, 스택 문제인데 굳이 사용하지 않고 비교로 풀 수 있었다.

### 알게된 내용
기존엔 `ArrayList`를 사용했는데, 다른 풀이를 보고 `LinkedList`도 사용해보았다.

`LinkedList`를 사용하면 `getLast()`, `getFirst()`, `removeFirst()`, `removeLast()`, `offer()`, `poll()` 등의 메서드가 사용가능하다.

특정 인덱스 조회가 없는 경우엔 `LinkedList` 사용을 고려해볼만 한 것 같다.

### 풀이
```java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (result.getLast() != arr[i]) {
                result.add(arr[i]);
            }
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}
```
