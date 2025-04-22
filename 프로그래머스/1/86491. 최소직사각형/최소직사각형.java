class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int[] size : sizes) {
            int width = size[0] < size[1] ? size[1] : size[0];
            int height = size[0] < size[1] ? size[0] : size[1];
            
            if (maxWidth < width) {
                maxWidth = width;
            }
            if (maxHeight < height) {
                maxHeight = height;
            }
        }
        
        return maxWidth * maxHeight;
    }
}