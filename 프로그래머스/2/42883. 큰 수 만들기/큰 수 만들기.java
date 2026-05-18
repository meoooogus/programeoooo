import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Deque<Character> stk = new ArrayDeque<>();

        for (char ch : number.toCharArray()) {
            while (!stk.isEmpty() && ch > stk.peekLast() && k > 0) {
                stk.pollLast();
                k--;
            }
            stk.offerLast(ch);    
        }
        while (k > 0) {
            stk.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char x : stk)
            sb.append(x);
        answer = sb.toString();
        return answer;
    }
}