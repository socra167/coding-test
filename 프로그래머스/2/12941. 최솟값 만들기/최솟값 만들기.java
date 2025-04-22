import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < B.length; i++) {
            sum += A[i] * B[B.length - i - 1];
        }
        return sum;
    }
}