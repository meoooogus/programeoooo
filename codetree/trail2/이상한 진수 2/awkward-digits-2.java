import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        // Please write your code here.
        char[] chars = a.toCharArray();
        boolean dirty = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = '1';
                dirty = true;
                break;
            }
        }
        if (dirty == false) {
            chars[chars.length - 1] = '0';
        }
        System.out.println(Integer.parseInt(new String(chars), 2));
    }
}
