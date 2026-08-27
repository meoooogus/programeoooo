import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        char[] chars = str.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '(') {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == ')') result++;
                }
            }
        }
        System.out.println(result);
    }
}