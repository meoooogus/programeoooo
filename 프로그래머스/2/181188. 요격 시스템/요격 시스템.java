import java.util.Arrays;

// 끝점을 기준으로 오름차순 정렬하면,
// 가장 이른 끝점에 미사일을 쏘는 것이 항상 최적이다
// 마지막에 쏜 미사일과 각각의 미사일과 비교하며 값 초기화

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
