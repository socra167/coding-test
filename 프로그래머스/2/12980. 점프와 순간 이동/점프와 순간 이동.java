public class Solution {
    public int solution(int n) {
        int ans = 0;
        while (0 < n) {
            ans += (n % 2);
            n /= 2;
        }
        return ans;
    }
}