import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();
        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();
        int mx1 = sc.nextInt();
        int my1 = sc.nextInt();
        int mx2 = sc.nextInt();
        int my2 = sc.nextInt();
        // Please write your code here.
        int A = (ax2 - ax1) * (ay2 - ay1);
        int B = (bx2 - bx1) * (by2 - by1);
        int overlapA = overlap(ax1, ay1, ax2, ay2, mx1, my1, mx2, my2);
        int overlapB = overlap(bx1, by1, bx2, by2, mx1, my1, mx2, my2);
        System.out.println(A - overlapA + B - overlapB);
    }
    private static int overlap(
        int x1, int y1, int x2, int y2, int mx1, int my1, int mx2, int my2
        ) {
            int dupX = Math.max(0, Math.min(x2, mx2) - Math.max(x1, mx1));
            int dupY = Math.max(0, Math.min(y2, my2) - Math.max(y1, my1));
            return dupX * dupY;
    }
}