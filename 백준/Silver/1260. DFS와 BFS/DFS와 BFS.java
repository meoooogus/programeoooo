import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = true;
            graph[to][from] = true;
        }

        boolean[] visited = new boolean[N+1];
        dfs(graph, visited, V, N);
        System.out.println();
        bfs(graph, V, N);
    }

    public static void dfs(boolean[][] graph, boolean[] visited, int V, int N) {
        System.out.print(V + " ");
        visited[V] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[V][i] && !visited[i])
                dfs(graph, visited, i, N);
        }
    }
    public static void bfs(boolean[][] graph, int V, int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[V] = true;
        queue.offer(V);

        while (!queue.isEmpty()) {
            int value = queue.poll();
            System.out.print(value + " ");
            for (int i = 1; i <= N; i++) {
                if (graph[value][i] && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
