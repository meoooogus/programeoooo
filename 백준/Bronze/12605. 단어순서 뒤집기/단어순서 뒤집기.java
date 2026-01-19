import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Stack<String> stk = new Stack<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(arr[i]);
            while (st.hasMoreTokens()) {
                stk.push(st.nextToken());
            }
            System.out.print("Case #" + (i+1) + ": ");
            while (!stk.isEmpty())
                System.out.print(stk.pop() + " ");
            System.out.println();
        }

    }
}
