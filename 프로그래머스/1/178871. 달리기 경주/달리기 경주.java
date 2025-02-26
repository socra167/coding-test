import java.util.*;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer;
        Map<String, Integer> indexMap = new HashMap<>(); // 선수이름, index를 저장하는 Map
        ArrayList<String> playerLocation = new ArrayList<String>(); // 선수들의 위치를 저장하는 리스트
        String nextPlayer; // 불린 선수의 앞에 달리고 있는 선수
        
        // 입력 데이터 저장
        for (int i = 0; i < players.length; i++){
            indexMap.put(players[i], i);
            playerLocation.add(players[i]);
        }
        
        for (String call : callings){
            nextPlayer = playerLocation.get(indexMap.get(call) - 1);
            playerLocation.set(indexMap.get(call) - 1, call);
            playerLocation.set(indexMap.get(call), nextPlayer);
            indexMap.put(nextPlayer, indexMap.get(call));
            indexMap.put(call, indexMap.get(call) - 1);
        }
        
        answer = playerLocation.toArray(new String[0]);
        return answer;
    }
} 