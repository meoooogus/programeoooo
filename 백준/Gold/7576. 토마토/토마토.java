import java.io.*;
import java.util.*;

class Main {

    static int[][] grid;
    static int[][] distance;
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    static int N; // 행
    static int M; // 열

    static List<int[]> vertex = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                grid[i][j] = value;
                if (value == 1)
                    vertex.add(new int[] {i, j});
            }
        }
        System.out.println(bfs());

    }

    static int bfs() {
        int nr, nc;
        Deque<int[]> q = new ArrayDeque<>();
        for (int[] arr : vertex) {
            q.offer(arr);
        }
        int r, c;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            r = cur[0];
            c = cur[1];
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];
                if (nr < 0 || nr >= N) continue;
                if (nc < 0 || nc >= M) continue;
                if (grid[nr][nc] != 0) continue;
                distance[nr][nc] = distance[r][c] + 1;
                grid[nr][nc] = 1;
                q.offer(new int[] {nr, nc});
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (distance[i][j] > max) {
                    max = distance[i][j];
                }
                if (grid[i][j] == 0)
                    return -1;
            }
        }
        return max;
    }
}
