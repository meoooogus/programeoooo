import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> answer = new LinkedHashSet<>();
        s = s.substring(2, s.length() - 2);
        String[] ss = s.split("\\},\\{");
        Arrays.sort(ss, (a, b) -> a.length() - b.length());
        for (String value : ss) {
            String[] split = value.split(",");
            for (String c : split)
                answer.add(Integer.parseInt(c));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
// 1,2,3},{2,1},{1,2,4,3},{2
// 1,2,3
// 2,1
// 1,2,4,3
// 2
