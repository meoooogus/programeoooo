import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        boolean[][] G = new boolean[N+1][N+1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            G[from][to] = true;
            G[to][from] = true;
        }
        int result = bfs(G, 1, N);
        System.out.println(result);
    }
    static public int bfs(boolean[][] G, int V, int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);
        visited[V] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            count++;
            for (int i = 1; i <= N; i++) {
                if (G[value][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return count-1;
    }
}
