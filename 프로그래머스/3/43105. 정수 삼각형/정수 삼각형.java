class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        
        for (int i = 1; i < size; i++) {
            triangle[i][0] += triangle[i-1][0];
            
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            
            triangle[i][i] += triangle[i-1][i-1];
        }
        
        for (int i = 0; i < size; i++) {
            if (triangle[size-1][i] > answer)
                answer = triangle[size-1][i];
        }
        
        return answer;
    }
}
//(triangle[i-1][j] > triangle[i-1][j-1] ? triangle[i-1][j] : triangle[i-1][j-1]);