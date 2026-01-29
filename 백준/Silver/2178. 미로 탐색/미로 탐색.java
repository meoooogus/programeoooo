import java.io.*;
import java.util.*;

class Main {
    static int[][] grid;
    static int[] mr = {-1, 1, 0, 0};
    static int[] mc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                grid[i][j] = charArray[j] - '0';
            }
        }
        System.out.println(bfs(N, M));
    }

    static int bfs(int N, int M) {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[N][M];

        int[] cur;
        int nr, nc;
        int r, c;
        q.offer(new int[] {0, 0});
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            cur = q.poll();
            r = cur[0];
            c = cur[1];
            for (int i = 0; i < 4; i++) {
                nr = r + mr[i];
                nc = c + mc[i];
                if (nr < 0 || nr >= N) continue;
                if (nc < 0 || nc >= M) continue;
                if (grid[nr][nc] == 0) continue;
                if (dist[nr][nc] != 0) continue;
                q.offer(new int[] {nr, nc});
                dist[nr][nc] = dist[r][c] + 1;
            }
        }
        return dist[N-1][M-1];
    }
}
