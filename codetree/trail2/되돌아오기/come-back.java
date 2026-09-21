import java.util.Scanner;
public class Main {
    static int[] dx = new int[] {0, 1, -1, 0};
    static int[] dy = new int[] {-1, 0, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] dir = new char[n];
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dir[i] = sc.next().charAt(0);
            dist[i] = sc.nextInt();
        }
        // Please write your code here.
        int time = 0;
        int answer = -1;
        int r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            int cmd = toIndex(dir[i]);
            for (int j = 0; j < dist[i]; j++) {
                time++;
                r += dx[cmd]; c += dy[cmd];
                if (r == 0 && c == 0) {
                    answer = time;
                    break;
                }
            }
            if (answer != -1) break;
        }
        System.out.println(answer);
    }
    static int toIndex(char dir) {
        if (dir == 'W') {
            return 0;
        } else if (dir == 'S') {
            return 1;
        } else if (dir == 'N') {
            return 2;
        } else {
            return 3;
        }
    }
}