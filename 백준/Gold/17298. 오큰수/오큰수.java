import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Stack<Integer> stk = new Stack<>();
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        // 3 5 2 7
        /**
         * 스택의 피크와 다음값비교
         * 크면 다음값 인덱스 저장, 스택팝
         * 다음값 푸시
         */

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            while (!stk.isEmpty() && ints[stk.peek()] < ints[i]) {
                answer[stk.pop()] = ints[i];
            }
            stk.push(i);
        }

        while (!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
