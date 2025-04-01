#Coding-Test 

---

# H－Index

### 접근

역순으로 정렬 후 순회 도중  `sortedCitations[index] < index` 인 경우, `sortedCitations[index]` 의 인용수 이상인 논문이 `index` 개 이상 존재하는 것이다.

이 경우 문제의 조건을 만족하는 것이므로 해당 위치의 인덱스가 정답이다.

조건을 만족하지 않는 예외 케이스들이 있었는데, `[0, 0, 0, 0]` 으로 모두 0인 경우, `[9999, 9999, 9999, 9998]` 처럼 마지막 숫자까지 전체 논문의 수보다 인용 수가 많은 경우였다.

`sortedCitations.length < sortedCitations[sortedCitations.length - 1]` 이면 마지막 논문의 인용수가 전체 논문의 수보다 많은 경우이고, 반대의 경우는 아예 인용 수 가 없는 경우다.

`for`문을 탈출하는 예외 케이스들을 처리해줬다.

---

처음 문제를 보고 예외 케이스들을 떠올리지 못해 복잡해졌는데, 다른 풀이를 보고 순회하면서 가능한 최대 H-index를 갱신해주면 예외 케이스들도 한 번에 처리 가능해지는 걸 알았다.

코드는 더 간결해지긴 하지만, 정답이 정해진 경우에도 끝까지 순회하기 때문에 이후 풀이에서 어느 정도 성능 낭비가 발생할 순 있을 것 같다.

### 알게된 내용


### 첫 풀이
```java
import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        int[] sortedCitations = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i)
            .toArray();

        for (int i = 0; i < sortedCitations.length; i++) {
            if (sortedCitations[i] < i) {
                return i;
            }
            if (sortedCitations[i] < (i + 2)) {
                return sortedCitations[i];
            }
        }
        return sortedCitations.length < sortedCitations[sortedCitations.length - 1] ?
                    sortedCitations.length : 0;
    }
}
```

### 풀이
```java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int[] sortedCitations = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i)
            .toArray();
        
        int max = 0;
        for (int i = 0; i < sortedCitations.length; i++) {
            int currentMax = Math.min(i + 1, sortedCitations[i]);
            if (max < currentMax) {
                max = currentMax;
            }
        }
        
        return max;
    }
}
```
