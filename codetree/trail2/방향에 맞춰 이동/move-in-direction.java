import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};
        int n = sc.nextInt();
        int curX = 0, curY = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            // Please write your code here.
            int idx = cvrt(direction);
            curX += dx[idx] * distance;
            curY += dy[idx] * distance;
        }
        System.out.println(curX + " " + curY);
    }
    static int cvrt(char dir) {
        if (dir == 'W') {
            return 0;
        } else if (dir == 'S') {
            return 1;
        } else if (dir == 'N') {
            return 2;
        } else if (dir == 'E') {
            return 3;
        } else {
            return -1;
        }
    }
}