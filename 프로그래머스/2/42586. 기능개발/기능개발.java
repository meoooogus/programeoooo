import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int size = progresses.length;
        
        for (int i = 0; i < size; i++) {
            progresses[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        int cur = 0;
        int idx = 0;
        while (idx < size) {
            int count = 0;
            while (idx < size && progresses[cur] >= progresses[idx]) {
                count++;
                idx++;
            }
            answer.add(count);
            cur = idx;    
        }
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
// 7, 70, 45
// 7, 3, 9