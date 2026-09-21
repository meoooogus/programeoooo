import java.util.Scanner;
public class Main {
    static int[][] grid;
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        grid = new int[n][m];
        int val = 1;
        int cmd = 0;
        int curX = 0, curY = 0;
        for (int i = 0; i < n * m; i++) {
            grid[curX][curY] = val++;
            
            int nx = curX + dx[cmd];
            int ny = curY + dy[cmd];
            if (moveable(nx, ny, n, m)) {
                curX = nx; curY = ny;
            } else {
                cmd = (cmd + 1) % 4;
                curX += dx[cmd]; curY += dy[cmd];
            }
        }
        print(grid, n, m);
    }
    static boolean moveable(int r, int c, int n, int m) {
        if (0 <= r && r <= n-1 && 0 <= c && c <= m-1 && grid[r][c] == 0)
            return true;
        else return false;
    }
    static void print(int[][] grid, int n, int m) {
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(grid[i][j] + " ");
            }
            System.out.println(sb);
        }
    }
}