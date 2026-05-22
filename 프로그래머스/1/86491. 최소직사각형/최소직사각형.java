class Solution {
    public int solution(int[][] sizes) {
        
        int maxW = 0;
        int maxH = 0;
        for (int[] s : sizes) {
            int w = Math.max(s[0], s[1]);
            int h = Math.min(s[0], s[1]);
            
            maxW = Math.max(w, maxW);
            maxH = Math.max(h, maxH);
        }
        
        return maxW * maxH;
    }
}