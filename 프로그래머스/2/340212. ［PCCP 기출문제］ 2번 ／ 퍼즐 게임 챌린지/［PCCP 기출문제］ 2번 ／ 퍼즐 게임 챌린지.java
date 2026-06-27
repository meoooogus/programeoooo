import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int l = 1;
        int r = Arrays.stream(diffs).max().getAsInt();
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPass(mid, diffs, times, limit)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean isPass(int level, int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        long total = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int cur = times[i];
            if (level >= diffs[i]) {
                total += cur;
            } else {
                total += (prev + cur) * (diffs[i] - level) + cur;
            }
            if (total > limit)
                return false;
            prev = cur;
        }
        return true;
    }
}

// 실패시에, (직전단계 소요시간 + 현재 소요시간) * 실패횟수 + 현재 소요시간 
// 성공시에, 현재 소요시간
