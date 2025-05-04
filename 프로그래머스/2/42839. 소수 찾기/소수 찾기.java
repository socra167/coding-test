import java.util.*;

class Solution {
    private Set<Integer> numberSet = new HashSet<>();
    private boolean[] visited;
    private char[] digits;
    
    public int solution(String numbers) {
        digits = numbers.toCharArray();
        visited = new boolean[digits.length];
        
        for (int i = 1; i <= digits.length; i++) {
            dfs("", i);
        }
        
        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(String current, int targetLength) {
        if (current.length() == targetLength) {
            numberSet.add(Integer.parseInt(current));
            return;
        }
        
        for (int i = 0; i < digits.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + digits[i], targetLength);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}