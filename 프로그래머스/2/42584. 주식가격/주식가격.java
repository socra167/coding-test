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