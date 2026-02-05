import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {
        int count = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        int pop;
        while (!q.isEmpty()) {
            int loop = q.size();
            for (int i = 0; i < loop; i++) {
                pop = q.poll();
                visited[pop] = true;
                if (pop == K)
                    return count;
                int[] next = {pop*2, pop+1, pop-1};
                for (int nx : next) {
                    if (nx < 0 || nx > 100000 || visited[nx]) continue;
                    q.offer(nx);
                }
            }
            count++;
        }
        return -1;
    }
}
