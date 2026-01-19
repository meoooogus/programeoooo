import java.util.Scanner;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            stk.push(scanner.nextInt());
        }

        int count = 0;
        int h = 0;

        for (int i = 0; i < N; i++) {
            int value = stk.pop();
            if (value > h) {
                count++;
                h = value;
            }
        }

        System.out.println(count);
    }
}
//6 9 7 6 4 6