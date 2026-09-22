import java.util.Scanner;
public class Main {
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        // Please write your code here.
        char[] cmds = commands.toCharArray();
        int dir = 0;
        int x = 0, y = 0;
        int time = 0;
        int answer = -1;
        for (char cmd : cmds) {
            time++;
            if (cmd == 'F') {
                x += dx[dir]; y += dy[dir];
            } else if (cmd == 'R') {
                dir = (dir + 1) % 4;
            } else if (cmd == 'L') {
                dir = (dir == 0) ? 3 : dir - 1;
            }
            if (x == 0 && y == 0) {
                answer = time;
                break;
            }
        }
        System.out.println(answer);
    }
}