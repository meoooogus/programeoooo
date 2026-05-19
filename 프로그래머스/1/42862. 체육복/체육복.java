class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n + 1];
        
        for (int i : lost) {
            clothes[i]--;
        }
        for (int i : reserve) {
            clothes[i]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == -1) {
                if (i > 1 && clothes[i-1] == 1) {
                    clothes[i]++;
                    clothes[i-1]--;
                } else if (i < n && clothes[i+1] == 1) {
                    clothes[i]++;
                    clothes[i+1]--;
                }
            }
        }
        
        for (int i = 1; i <= n; i++)
            if (clothes[i] >= 0)
                answer++;
        
        return answer;
    }
}