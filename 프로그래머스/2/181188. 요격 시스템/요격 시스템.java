import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int rocket = 0;
        for (int[] target : targets) {
            if (target[0] < rocket)
                continue;
            rocket = target[1];
            answer++;
        }
        
        return answer;
    }
}