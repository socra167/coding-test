class Solution {
    public int solution(int n) {
        int answer = 0;
        int tmp = 0;
        
        for (int i = 1; i <= n; i++) {
            tmp = (i * (i - 1)) / 2;
            
            if ((n - tmp) < i) {
                break;
            }
            
            if ((n - tmp) % i == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}