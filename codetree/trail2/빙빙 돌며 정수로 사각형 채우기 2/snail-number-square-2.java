import java.util.Scanner;
public class Main {
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        grid = new int[n][m];
        int dir = 0;
        int x = 0, y = 0;
        for (int i = 1; i <= n * m; i++) {
            grid[x][y] = i;
            if (!inRange(x + dx[dir], y + dy[dir], n, m)) {
                dir = (dir + 1) % 4;
            }
            x = x + dx[dir]; y = y + dy[dir];
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(grid[i][j] + " ");
            }
            System.out.println(sb);
        }
    }
    static boolean inRange(int x, int y, int n, int m) {
        if (0 <= x && x < n && 0 <= y && y < m && grid[x][y] == 0) return true;
        return false;
    }
}