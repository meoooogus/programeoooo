import java.util.Scanner;

public class Main {
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        String D = sc.next();
        // Please write your code here.
        int cmd = toIdx(D);
        for (int i = 0; i < T; i++) {
            int nr = R + dx[cmd];
            int nc = C + dy[cmd];
            if (inRange(nr, nc, N)) {
                R = nr; C = nc;
            } else {
                if (nr < 1) {
                    cmd = 1;
                } else if (nr > N) {
                    cmd = 0;
                } else if (nc < 1) {
                    cmd = 3;
                } else if (nc > N) {
                    cmd = 2;
                }
            }
        }
        System.out.println(R + " " + C);
    }
    static int toIdx(String D) {
        if (D.equals("U")) {
            return 0;
        } else if (D.equals("D")) {
            return 1;
        } else if (D.equals("L")) {
            return 2;
        } else {
            return 3;
        }
    }
    static boolean inRange(int R, int C, int N) {
        if (1 <= R && R <= N && 1 <= C && C <= N) return true;
        else return false;
    }
}