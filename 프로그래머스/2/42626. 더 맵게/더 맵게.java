import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville)
            pq.offer(i);
        
        while (pq.size() > 1 && pq.peek() < K) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.offer(s1 + s2 * 2);
            answer++;
        }
        if (pq.peek() < K)
            return -1;
        return answer;
    }
}