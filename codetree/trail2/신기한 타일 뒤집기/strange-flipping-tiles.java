import java.util.Scanner;
public class Main {
    final static int OFFSET = 1000 * 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tiles = new int[2 * OFFSET + 1];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            if (d == 'L') {
                for (int k = 0; k < x; k++) {
                    tiles[cur + OFFSET - k] = -1;
                }
                cur -= (x - 1);
            } else {
                for (int k = 0; k < x; k++) {
                    tiles[cur + OFFSET + k] = 1;
                }
                cur += (x - 1);
            }
        }
        int white = 0, black = 0;
        for (int tile : tiles) {
            if (tile == -1) white++;
            else if (tile == 1) black++;
        }
        System.out.println(white + " " + black);
    }
}