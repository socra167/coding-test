### 문제 링크
[Programmers](https://school.programmers.co.kr/learn/courses/30/lessons/181188)

## 접근

처음엔 `targets`를 List에 저장해 순회하면서 겹치는 부분이 있으면 범위를 좁힌 후 target을 제외시키고, 겹치는 부분이 없으면 발사 횟수를 증가시키는 방법으로 생각했다.

하지만 이 방식은 `targets`의 순서에 따라 값이 달라지고 항상 최소한의 발사 횟수를 얻을 순 없었다.

따라서 targets의 두 번째 인자로 정렬해 같은 방식으로 풀이했다. (custom sort)

`Comparator`개념을 모르고 접해서 정렬이 어려웠다.

## 알게 된 내용

- `Arrays.sort` 의 두 번째 인자로 `Comparator` 함수 인터페이스 사용 가능
    - 원래는 `Comparator` 를 상속받아서 오버라이딩 해야 하는데
    - 람다식 `(o1, o2) → o1[1] - o2[2]` 표현을 Arrays.sort의 Comparator 인자로 사용해 두 번째 값을 기준으로 오름차순 정렬을 할 수 있었음

## 풀이

```java
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int last = targets[0][1];
        
        for (int[] target : targets) {
            if (target[0] < last) {
                last = target[1] < last ? target[1] : last;
                continue;
            }
            last = target[1];
            answer++;
        }
        
        return answer;
    }
}
```

`last` 변수는 요격 미사일을 발사한다고 가정했을 때, 허용되는 최대 값이다.

예를 들어 targets가 A, B, C, D 라는 범위로 이루어져 있다고 할 때,

초기 `last`는 A[1]을 가리킨다.

이후 B가 last의 범위 안에 존재하는지 확인한다. (target[0] < last)

존재한다면, 한 번에 같이 격추시키면 되므로 다음부터는 A, B 를 같이 격추시키는 범위 안에서 다른 미사일을 격추할 수 있는지 탐색하면 된다.

따라서 last는 A, B를 모두 격추할 수 있는 범위를 가리키도록 `last, target[1] 의 최솟값`으로 갱신한다.

다시, last의 범위로 수용할 수 없는 범위가 나온다면 요격 미사일 수를 늘린 후 (answer++) 새로운 범위로 같은 방식으로 진행하면 된다. 이 때 last도 초기와 같은 방식으로 갱신한다.

~~초기 값을 targets[0][1]로 주어 이미 발사했다는 가정으로 시작하고 있으므로 answer를 1에서 부터 시작시켰다.~~

순회 마지막의 범위는 세지 않으므로 answer를 1부터 시작시켰다.
