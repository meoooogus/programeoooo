import java.util.Scanner;

class Main {
    static char[][] stars;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        stars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stars[i][j] = '*';
            }
        }
        //
        pattern(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void pattern(int r, int c, int size) {
        int part = size / 3;
        int dr = r + part;
        int dc = c + part;
        if (part == 0)
            return;
        for (int i = dr; i < dr + part; i++) {
            for (int j = dc; j < dc + part; j++) {
                stars[i][j] = ' ';
            }
        }
        for (int i = r; i < r + size; i = i + part) {
            for (int j = c; j < c + size; j = j + part) {
                if (i == dr && j == dc)
                    continue;
                pattern(i, j, part);
            }
        }
    }
}
//  0 0 /  0 9 /  0 18
//  9 0 /  9 9 /  9 18
// 18 0 / 18 9 / 18 18
//
//        *********
//        * ** ** *
//        *********
//        ***   ***
//        * *   * *
//        ***   ***
//        *********
//        * ** ** *
//        *********