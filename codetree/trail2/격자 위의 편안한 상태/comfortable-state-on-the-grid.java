import java.util.Scanner;

public class Main {
    static boolean[][] grid;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] points = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        // Please write your code here.
        grid = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int pr = points[i][0];
            int pc = points[i][1];
            grid[pr - 1][pc - 1] = true;
            if (isStable(pr - 1, pc - 1, n)) System.out.println(1);
            else System.out.println(0);
        }
    }
    static boolean isStable(int r, int c, int n) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (inRange(nr, nc, n) && grid[nr][nc] == true) count++;
        }
        return count == 3 ? true : false;
    }
    static boolean inRange(int r, int c, int n) {
        if (0 <= r && r <= n-1 && 0 <= c && c <= n-1) return true;
        return false;
    }
}