import java.util.*;

class Solution {
    public int[] solution(String s) {
        int convertCount = 0;
        int removedZeroCount = 0;

        while (!s.equals("1")) {
            int ones = getOneCount(s);
            removedZeroCount += (s.length() - ones);
            s = Integer.toBinaryString(ones);
            convertCount++;
        }

        return new int[]{convertCount, removedZeroCount};
    }

    private int getOneCount(String exp) {
        return (int) exp.chars()
            .filter(x -> x == '1')
            .count();
    }
}
