import java.util.*;


class Solution {
    public String solution(String s) {
        String answer = "";
        List<Long> numList = new ArrayList<>();
        String[] numbers = s.split(" ");
        
        for (String number : numbers)
            numList.add(Long.parseLong(number));
        
        Collections.sort(numList);
        
        answer = numList.get(0).toString() + " " +
            numList.get(numList.size() - 1).toString();
        
        return answer;
    }
}