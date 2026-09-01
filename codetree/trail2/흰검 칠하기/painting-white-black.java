import java.util.Scanner;

public class Main {
    static final int OFFSET = 1000 * 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        char[] dir = new char[n];

        int cur = 0;
        int[] blacks = new int[2 * OFFSET + 1];
        int[] whites = new int[2 * OFFSET + 1];
        int[] tiles = new int[2 * OFFSET + 1];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
            if (dir[i] == 'L') {
                for (int d = 0; d < x[i]; d++) {
                    whites[cur + OFFSET - d]++;
                    tiles[cur + OFFSET - d] = -1;
                }
                cur -= (x[i] -1);
            } else {
                for (int d = 0; d < x[i]; d++) {
                    blacks[cur + OFFSET + d]++;
                    tiles[cur + OFFSET + d] = 1;
                }
                cur += (x[i] -1);;
            }    
        }
        int grey = 0;
        int black = 0;
        int white = 0;
        for (int i = 0; i < 2 * OFFSET + 1; i++) {
            if (blacks[i] >= 2 && whites[i] >= 2)  {
                grey++;
            } else {
                if (tiles[i] == -1) white++;
                else if (tiles[i] == 1) black++;
            }
        }
        System.out.println(white + " " + black + " " + grey);
    }
}