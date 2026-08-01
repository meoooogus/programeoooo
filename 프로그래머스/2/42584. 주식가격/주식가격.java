import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stk = new ArrayDeque<>();
        int n = prices.length;
        int[] result = new int[n];
        int cmp = 0;
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && prices[stk.peek()] > prices[i]) {
                int idx = stk.pop();
                result[idx] = i - idx;
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            int idx = stk.pop();
            result[idx] = n - idx -1;
        }
        return result;
    }
}

