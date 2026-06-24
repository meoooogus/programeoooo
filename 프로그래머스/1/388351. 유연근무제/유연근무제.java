import java.util.Arrays;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        
        for (int i = 0; i < n; i++) {
            boolean event = true;
            int deadline = calDeadline(schedules[i]);
            
            for (int j = 0; j < 7; j++) {
                int day = (startday - 1 + j) % 7;
                if (day >= 5)
                    continue;
                if (timelogs[i][j] > deadline)
                    event = false;
            }
            
            if (event)
                answer++;
        }
        
        return answer;
    }
    
    private int calDeadline(int value) {
        int h = value / 100;
        int m = (value % 100) + 10;
        if (m >= 60) {
            m -= 60; h++;
        }
        return h * 100 + m;
    }
}