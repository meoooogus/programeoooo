import java.util.*;

class Solution {
    private static Deque<Character> stk = new ArrayDeque<>();
    private static int result = 0;
    
    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            String rotate = s.substring(i) + s.substring(0, i);
            char[] ra = rotate.toCharArray();
            stack(ra);
            stk.clear();
        }
        return result;
    }

    private void stack(char[] ra) {
        for (char c : ra) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);   
            } else if (stk.isEmpty()) {
                return;    
            } else if (c == ')' && stk.peek() == '('
                || c == '}' && stk.peek() == '{'
                || c == ']' && stk.peek() == '[') {
                stk.pop();
            }    
        }
        if (stk.isEmpty())
            result++;
    }
}
