import java.util.Scanner;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        // 4 3 6 8 7 5 2 1
        // value값을 순서대로 늘려나가면서, i번째 인덱스보다 커질 때까지 push()
        // 스택의 피크가 i번째 인덱스보다 작거나 같으면? 팝
        // + + + + - - + +
        // 1 2 5 3 4

        Stack<Integer> stk = new Stack<>();
        int value = 1;
        int i = 0;

        StringBuilder sb = new StringBuilder();
        while (i < n) {
            while (value <= arr[i]) {
                stk.push(value++);
                sb.append("+\n");
            }
            if (stk.peek() == arr[i]){
                stk.pop();
                sb.append("-\n");
            }
            i++;
        }
        if (stk.isEmpty())
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
