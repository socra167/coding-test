#Coding-Test 

---

# 의상

## 접근

문제에 같은 이름을 가진 의상은 존재하지 않는다는 전제가 있었으므로 의상의 종류별로 각각 몇 개씩 존재하는지만 알면 답을 구할 수 있다.

1. 입력 `clothes`를 `의상 종류 - 개수`의 HashMap으로 저장한다.
2. 의상 종류별 개수를 알면, 가능한 조합의 수를 구할 수 있다.

## 알게된 내용

### **`HashMap.containsKey()`**

Map에 키가 존재하는지 확인할 때, `HashMap.keySet().contains()`를 하지 않고 `HashMap.containsKey()`로 더 간단하게 할 수 있다.

### **`List<Integer> list = new ArrayList<>(hashMap.values())`**

HashMap의 value들만 얻고 싶을 때 `HashMap.values()`를 사용하면 value들의 `Collection<V>`을 얻을 수 있다.

이후 `new ArrayList<>`의 인자로 넣어 리스트로 변환했다.

### `HashMap.getOrDefault()` 를 증가에도 활용

Map의 value를 갱신하고 싶을 때, 새 데이터를 추가하는 것과 마찬가지로 `put()`을 사용하면 되므로 value를 넣는 부분에 `getOrDefault()`를 사용하면 검사 로직을 줄일 수 있다.

### 조합 구하기

조합을 계산할 때 특정 종류를 사용한 경우도 있고, 사용하지 않는 경우도 있어서 고민했다.

1개 종류를 사용한 경우, 2개 종류를 사용한 경우, ... 의 가능한 조합 수를 생각하는 것보다, 차라리 각각의 개수에 (고르지 않은 경우를 의미하는)1을 더해 모든 종류를 사용한 경우로 구한 다음 -1(모두 고르지 않은 경우는 제외) 해주는 게 훨씬 쉽게 풀렸다.

이렇게 풀면, A가 5개, B가 4개, C가 3개일 때 `(5 + 1) \* (4 + 1) \* (3 + 1) - 1` 으로 쉽게 풀린다.

## 풀이

```java
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

```
