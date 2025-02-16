import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int lLoc = 10;
        int rLoc = 12;
        int lCost = 0;
        int rCost = 0;
        
        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            }
            if ((number - 1) % 3 == 0) { // left
                lLoc = number;
                answer.append("L");
            } else if ((number - 1) % 3 == 2) { // right
                rLoc = number;
                answer.append("R");
            } else { // middle
                
                lCost = Math.abs(((lLoc - 1) / 3) - ((number - 1) / 3)) 
                    + Math.abs(((lLoc - 1) % 3) - ((number - 1) % 3));
                rCost = Math.abs(((rLoc - 1) / 3) - ((number - 1) / 3)) 
                    + Math.abs(((rLoc - 1) % 3) - ((number - 1) % 3));
                
                if (lCost == rCost) {
                    if (hand.equals("left")) {
                        lLoc = number;
                        answer.append("L");
                    } else {
                        rLoc = number;
                        answer.append("R");
                    }
                } else if (lCost < rCost) {
                    lLoc = number;
                    answer.append("L");
                } else {
                    rLoc = number;
                    answer.append("R");
                }
            }
        }
        
        return answer.toString();
    }
}