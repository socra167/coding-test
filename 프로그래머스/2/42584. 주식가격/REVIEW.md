#Coding-Test 

---

# 주식가격

---

### 접근

...

---

### 알게된 내용

...

---

### 첫 풀이

```java
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = prices.length - 1; -1 < i; i--) {
            pqueue.offer(prices[i]);
            Iterator<Integer> iter = pqueue.iterator();
            
            int cnt = 0;
            while (iter.hasNext()) {
                
                if (iter.next() == prices[i]) {
                    // 우선순위 큐에서 뒤의 남은 수가 값이 됨
                    result.add(pqueue.size() - cnt - 1);
                    break;
                }
                cnt++;
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
```

### 풀이

```java
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while ((!stack.isEmpty()) && (prices[i] < prices[stack.peek()])) {
                int index = stack.pop();
                prices[index] = i - index;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            prices[index] = prices.length - index - 1;
        }
        
        return prices;
    }
}
```
