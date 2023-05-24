# 광물 캐기

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/172927)

## 접근

곡괭이가 모든 광물을 캘 수 있을만큼 충분한 경우, 광물 5개마다 피로도를 계산해서 피로도가 가장 많이 드는 연속된 5개의 광물에 대해 좋은 곡괭이를 우선적으로 소모하면 최소한의 피로도를 사용하게 될 것이다.

곡괭이가 충분하지 않은 경우, 사전에 캘 수 없는 자원은 제외시킨 뒤 같은 방식으로 구하면 해결할 수 있을 것이다.

광물 이름을 key, 곡괭이별 피로도를 value로 해시맵을 만들어 빠르게 조회할 수 있도록 했다.

`costs` 2차원 배열에 연속된 5개 광물마다 캘 때 소모되는 피로도의 합을 곡괭이별로 저장했다.

이후, 곡괭이가 충분하지 않은 경우를 위해 부족한 자원 영역에 누적 피로도를 0으로 초기화 시켰다.

피로도가 높은 자원 묶음부터 우선적으로 곡괭이를 소모할 수 있도록 피로도를 돌 곡괭이의 피로도를 기준으로 내림차순 정렬했다.

이제 `costs`를 순회하며 보유한 곡괭이 중 가장 좋은 곡괭이에 해당하는 피로도만큼을 합산하고 곡괭이를 소모시키면 결과를 구할 수 있다.

## 알게된 내용

- **2차원 배열의 초기화, Arrays.fill()을 사용한 방법**

처음엔 Integer[][] costs를 초기화 하기 위해 `Arrays.fill(costs, new Integer[]{0, 0, 0})` 을 사용했다. 잘 0으로 초기화되는 것처럼 보였지만 실제로는 같은 배열이 costs에 들어가 있어서 값을 변경할 때마다 모두 같이 변경되어 버렸다.

다시 생각해보니 Integer[]는 배열의 시작 주소가 전달될 것이므로 이렇게 되는 것이 당연했다.

2차원 배열의 각 배열마다 직접 리터럴 값으로 초기화하는 방식으로 변경하니 해결되었다.

- **2차원 배열은 향상 for문을 사용해 값 변경 가능**

풀이에서는 int i의 for문 iteration으로 초기화했지만, 향상된 for문을 사용해도 초기화가 가능하다.

```java
for (Integer[] cost : costs) {
	Arrays.fill(cost, 0);
}
```

cost에 costs의 배열별 시작 주소가 들어간다는 것을 생각해보면 cost를 통해 값을 변경해도 costs에 동일하게 반영됨을 알 수 있다.

## 풀이
```java
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
```
