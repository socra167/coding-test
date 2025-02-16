import java.util.Map;
import java.util.HashMap;


class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> scores = new HashMap<>(); // name, yearning을 저장할 Map
        
        for (int i = 0; i < name.length; i++) // Map에 저장
            scores.put(name[i], yearning[i]);
        
        for (int j = 0; j < photo.length; j++)
            for (String pic : photo[j])
                if (scores.get(pic) != null)
                    answer[j] += scores.get(pic);
        
        return answer;
    }
}