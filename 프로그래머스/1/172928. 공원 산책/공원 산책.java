import java.util.*;


class Solution {
    public int[] solution(String[] park, String[] routes) {
        final int height = park.length;
        final int width = park[0].length();
        int[] answer = new int[2];
        int[] direction = new int[2]; // route direction
        int step = 0; // route size
        char[][] location = new char[height][width];
        
        for (int i = 0; i < height; i++) {
            location[i] = park[i].toCharArray();
        }
        
        for (int i = 0; i < height * width; i++) {
            if (location[i / width][i % width] == 'S') {
                answer[0] = i / width;
                answer[1] = i % width;
            }
        }
        
        route:
        for (String route : routes) {
            step = Integer.parseInt(route.split(" ")[1]);
            switch (route.charAt(0)) {
                case 'E' :
                    direction[0] = 0;
                    direction[1] = 1;
                    break;
                case 'W' :
                    direction[0] = 0;
                    direction[1] = -1;
                    break;
                case 'S' :
                    direction[0] = 1;
                    direction[1] = 0;
                    break;
                case 'N' :
                    direction[0] = -1;
                    direction[1] = 0;
                    break;
            }
            
            for (int i = 1; i <= step; i++) {
                if (width <= answer[1] + direction[1] * i || answer[1] + direction[1] * i < 0) {
                    continue route;
                }
                if (height <= answer[0] + direction[0] * i || answer[0] + direction[0] * i < 0) {
                    continue route;
                }
                if (location[answer[0] + direction[0] * i][answer[1] + direction[1] * i] == 'X'){
                    continue route;
                }
            }
            
            answer[0] += direction[0] * step;
            answer[1] += direction[1] * step;
        }
        
        return answer;
    }
}