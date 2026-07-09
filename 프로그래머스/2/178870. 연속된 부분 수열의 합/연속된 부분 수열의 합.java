import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<Integer> candi = new ArrayList<>(2);
        int n = sequence.length;
        int start = 0;
        int sum = 0;
        int len = 1_000_000;
        for (int end = 0; end < n; end++) {
            sum += sequence[end];
            while (start <= end && sum > k) {
                sum -= sequence[start++];
            }
            if (sum == k && len > end - start) {
                len = end - start;
                candi.clear();
                candi.add(start); candi.add(end);
            }
        }
        
        return candi.stream().mapToInt(Integer::intValue).toArray();
    }
}