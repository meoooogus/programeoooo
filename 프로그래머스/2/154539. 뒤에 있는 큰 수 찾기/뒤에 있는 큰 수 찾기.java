import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && numbers[i] > numbers[stk.peek()]) {
                answer[stk.pop()] = numbers[i];
            }
            stk.push(i);
        }
        return answer;
    }
}
// 배열의 범위 1,000,000 -> 단순 이중루프 -> O(n^2) -> 다른 자료구조 선택
// 각 원소마다 오른쪽/왼쪽에서 조건을 만족하는 첫 번째 것 -> 모노토닉 스택(push 전에 단조성을 깨는 원소들을 모두 pop)
