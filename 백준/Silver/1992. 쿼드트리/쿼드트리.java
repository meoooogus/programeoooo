import java.util.*;
import java.io.*;

class Main {

    static char[][] grid;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        grid = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++) {
                grid[i][j] = input[j-1];
            }
        }
        split(1, 1, N);
        System.out.println(result);
    }

    static void split(int r, int c, int N) {
        boolean checked = check(r, c, N);
        char cmp = grid[r][c];
        if (checked) {
            result.append(cmp);
        } else {
            result.append('(');
            split(r, c, N/2);
            split(r, c + N/2, N/2);
            split(r + N/2, c, N/2);
            split(r + N/2, c + N/2, N/2);
            result.append(')');
        }
    }

    static boolean check(int r, int c, int N) {
        char cmp = grid[r][c];
        if (N != 1) {
            for (int i = r; i < r + N; i++) {
                for (int j = c; j < c + N; j++) {
                    if (cmp != grid[i][j])
                        return false;
                }
            }
        }
        return true;
    }
}

// 1 1
// 0 1
// (1101)