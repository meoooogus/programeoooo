import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stk = new ArrayDeque<>();
        
        char[] chs = s.toCharArray();
        
        for (char ch : chs) {
            if (ch == '(')
                stk.push(ch);
            else if (ch == ')') {
                if (stk.isEmpty()) {
                    answer = false;
                    break;
                }
                stk.pop();
            }
        }
        if (!stk.isEmpty())
            answer = false;

        return answer;
    }
}