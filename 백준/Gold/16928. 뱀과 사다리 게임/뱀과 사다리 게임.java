import java.util.*;
import java.io.*;

class Main {

    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];
    static int[] distance = new int[101];
    static int[] dice = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            board[key] = value;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            board[key] = value;
        }
        bfs();
        System.out.println(distance[100]);
    }

    public static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int next = cur + dice[i];
                if (next < 1 || next > 100) continue;
                if (board[next] != 0) {
                    next = board[next];
                }
                if (visited[next]) continue;
                q.offer(next);
                visited[next] = true;
                distance[next] = distance[cur] + 1;
            }
        }
    }
}
