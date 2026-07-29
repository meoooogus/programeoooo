import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int val = 0;
        while (sb.length() < t * m) {
            String baseN = Integer.toString(val, n);
            sb.append(baseN);
            val++;
        }
        StringBuilder answer = new StringBuilder();
        int idx = p - 1;
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(idx));
            idx += m;
        }
        return answer.toString().toUpperCase();
    }
}
// 0, 1, 1 0, 1 1, 1 0 0