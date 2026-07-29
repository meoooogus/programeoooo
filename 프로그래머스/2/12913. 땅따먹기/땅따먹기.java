class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] sums = new int[n][4];
        for (int i = 0; i < 4; i++) {
            sums[0][i] = land[0][i];    
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int value = getMax(land[i-1], j);
                sums[i][j] = land[i][j] += value;
            }
        }
        answer = getMax(land[n-1], -1); // -1을 넘겨서 직전 인덱스 영향X

        return answer;
    }
    
    private int getMax(int[] row, int idx) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (i == idx)
                continue;
            if (row[i] > max)
                max = row[i];
        }
        return max;
    }
}
// 1  2  3  5
// 10 11 12 11
// 16 15 13 13