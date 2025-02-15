class Solution {
    public int solution(int n, int m, int[] section) {
        int paintCount = 0; // 칠한 횟수
        int pivot = 0; // 처음부터 pivot 번째 까지의 벽은 칠할 필요 없음
        
        for (int block : section){
            if (pivot < block){
                paintCount++;
                pivot = block + m - 1;
            }
        }
        return paintCount;
    }
}