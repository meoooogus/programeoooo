import java.io.*;
import java.util.*;

class Main {

    static int[][] grid;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        grid = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        split(1, 1, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void split(int r, int c, int N) {
        boolean result = check(r, c, N);
        if (!result) {
            split(r, c, N/2);
            split(r, c + N/2, N/2);
            split(r + N/2, c, N/2);
            split(r+ N/2, c + N/2, N/2);
        }
    }

    static boolean check(int r, int c, int N) {
        int base = grid[r][c];
        if (N != 1) {
            for (int i = r; i < r+N; i++) {
                for (int j = c; j < c+N; j++) {
                    if (grid[i][j] != base) {
                        return false;
                    }
                }
            }
        }
        if (base == 1) {
            blue++;
        } else {
            white++;
        }
        return true;
    }
}
// N = 8
// N/2 = 4;
// 1~4 x 5~8 // 1~N/2 / N/2 +1 ~ N
// 1~4 x 5~8
// 5~8 x 1~4
// 5~8 x 5~8
