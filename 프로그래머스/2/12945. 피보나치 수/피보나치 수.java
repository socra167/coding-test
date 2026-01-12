class Solution {
    public int solution(int n) {
        long prev = 0L;
        long cur = 1L;
        long tmp = 0L;
        
        for (int i = 0; i < n - 1; i++) {
            tmp = cur;
            cur = (prev + cur) % 1234567;
            prev = tmp % 1234567;
        }
        
        return (int)cur;
    }
}