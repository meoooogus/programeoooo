import java.util.Scanner;
public class Main {
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d]; int ny = j + dy[d];
                    if (inRange(nx, ny, N) && arr[nx][ny] == 1) count++;
                }
                if (count >= 3) answer++;
            }
        }
        System.out.println(answer);
    }
    public static boolean inRange(int x, int y, int N) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}