import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i : arr) {
            if (stk.isEmpty() || stk.peekLast() != i) {
                stk.offer(i);
            } // Deque에서 스택은 0번째 인덱스 기준
        }
        answer = stk.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

        return answer;
    }
}