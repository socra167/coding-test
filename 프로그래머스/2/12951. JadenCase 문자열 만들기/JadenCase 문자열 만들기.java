class Solution {
    public String solution(String s) {
        String answer = "";
        char[] keywords = s.toCharArray();
        boolean blankFlag = true; // 공백을 입력 받은 적이 있는지
        
        for (int i = 0; i < s.length(); i++) {
            if (blankFlag){
                if ('a' <= keywords[i] && keywords[i] <= 'z')
                    keywords[i] -= 32;
                blankFlag = false;
            } else {
                if ('A' <= keywords[i] && keywords[i] <= 'Z')
                    keywords[i] += 32;
            }
            if (keywords[i] == ' ')
                blankFlag = true;
        }
        
        answer = String.valueOf(keywords);
        return answer;
    }
}