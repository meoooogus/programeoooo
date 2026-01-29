import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            grid = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                grid[r][c] = 1;
            }
            System.out.println(connected(N, M));
        }

    }

    static int connected(int N, int M) {
        int count = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    dfs(i, j, N, M);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, int N, int M) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr < 0 || nr >= N) continue;
            if (nc < 0 || nc >= M) continue;
            if (grid[nr][nc] == 0) continue;
            if (visited[nr][nc]) continue;
            dfs(nr, nc, N, M);
        }
    }

}

