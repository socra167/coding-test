import java.util.*;


class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int leftptr = 0;
        int rightptr = 0;
        int sum = sequence[0]; // 포인터 영역 부분 수열의 합
        
        while (rightptr < sequence.length) {
            if (sum == k) {
                if (rightptr - leftptr < answer[1] - answer[0]) {
                    answer[0] = leftptr;
                    answer[1] = rightptr;
                }
                if (leftptr == rightptr) {
                    break;
                }
                if (rightptr == sequence.length - 1) {
                    break;
                }
                sum -= sequence[leftptr];
                leftptr++;
                rightptr++;
                sum += sequence[rightptr];
            } else if (sum < k) { // right++
                if (rightptr == sequence.length - 1)
                    break;
                rightptr++;
                sum += sequence[rightptr];
            } else if (k < sum) { // left++
                if (leftptr == rightptr)
                    break;
                sum -= sequence[leftptr];
                leftptr++;
            }
        }
        
        return answer;
    }
}