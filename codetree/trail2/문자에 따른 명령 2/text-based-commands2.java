import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.
        char[] cmds = s.toCharArray();
        int dir = 0;
        int curX = 0, curY = 0;
        for (char cmd : cmds) {
            if (cmd == 'L') {
                dir--;
                if (dir < 0) dir = dx.length - 1;
            } else if (cmd == 'R') {
                dir = (dir + 1) % dx.length;
            } else if (cmd == 'F') {
                curX += dx[dir]; curY += dy[dir];
            }
        }
        System.out.println(curX + " " + curY);
    }
}