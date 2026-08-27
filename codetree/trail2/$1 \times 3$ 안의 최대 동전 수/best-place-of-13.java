import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 2; j++) {
                int cnt = 0;
                if (grid[i][j] == 1) cnt++;
                if (grid[i][j+1] == 1) cnt++;
                if (grid[i][j+2] == 1) cnt++;
                if (cnt > max) max = cnt;
            }
            if (max == 3) break;
        }
        System.out.println(max);
    }
}