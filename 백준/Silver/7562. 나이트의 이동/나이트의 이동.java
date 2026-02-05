import java.util.*;
import java.io.*;

class Main {

    static int[][] grid;
    static int[][] distance;
    static boolean[][] visited;
    static int I;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            grid = new int[I][I];
            distance = new int[I][I];
            visited = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(st.nextToken());
            int fromY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());
            bfs(fromX, fromY);
            System.out.println(distance[toX][toY]);
        }
    }

    public static void bfs(int fromX, int fromY) {
        int[] from = {fromX, fromY};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(from);
        visited[fromX][fromY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int j = 0; j < 8; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 0 || nx >= I) continue;
                if (ny < 0 || ny >= I) continue;
                if (visited[nx][ny]) continue;
                q.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
            }
        }

    }
}
