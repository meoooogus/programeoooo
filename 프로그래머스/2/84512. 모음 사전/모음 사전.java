import java.util.*;

class Solution {
    private static List<String> list = new ArrayList<>();
    private static char[] chars = new char[]{'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        dfs("");
        return list.indexOf(word) + 1;
    }
    
    private void dfs(String cur) {
        if (cur.length() == 5)
            return;
        for (int i = 0; i < 5; i++) {
            list.add(cur + chars[i]);
            dfs(cur + chars[i]);
        }
    }
}