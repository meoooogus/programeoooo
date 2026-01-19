import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            if (str.equals("."))
                break;
            boolean result = isBalance(str);
            if (result)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public static boolean isBalance(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '(' :
                case '{' :
                case '[' :
                    stk.push(c);
                    break;
                case ')' :
                    if (stk.isEmpty() || stk.peek() != '(')
                        return false;
                    stk.pop();
                    break;
                case '}' :
                    if (stk.isEmpty() || stk.peek() != '{')
                        return false;
                    stk.pop();
                    break;
                case ']' :
                    if (stk.isEmpty() || stk.peek() != '[')
                        return false;
                    stk.pop();
                    break;
                default:
                    break;
            }
        }
        return stk.isEmpty();
    }
}
