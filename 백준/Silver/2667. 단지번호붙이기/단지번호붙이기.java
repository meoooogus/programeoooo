import java.util.*;
import java.io.*;

class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                grid[i][j] = charArray[j] -'0';
            }
        }
        connected(N);
    }

    static int dfs(int r, int c, int N, int count) {
        visited[r][c] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= N) continue;
            if (nc < 0 || nc >= N) continue;
            if (grid[nr][nc] == 0) continue;
            if (visited[nr][nc]) continue;
            count = dfs(nr, nc, N, count);
        }
        return count;
    }

    static void connected(int N) {
        List<Integer> list = new ArrayList<>();
        int count;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    count = dfs(i, j, N, 0);
                    list.add(count);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
