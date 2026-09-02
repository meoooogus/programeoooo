import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt();
        int rect1_y1 = sc.nextInt();
        int rect1_x2 = sc.nextInt();
        int rect1_y2 = sc.nextInt();
        int rect2_x1 = sc.nextInt();
        int rect2_y1 = sc.nextInt();
        int rect2_x2 = sc.nextInt();
        int rect2_y2 = sc.nextInt();
        // Please write your code here.
        int w = rect1_x2 - rect1_x1;
        int h = rect1_y2 - rect1_y1;

        int px1 = Math.max(rect1_x1, rect2_x1);
        int px2 = Math.min(rect1_x2, rect2_x2);
        int py1 = Math.max(rect1_y1, rect2_y1);
        int py2 = Math.min(rect1_y2, rect2_y2);
        int ow = Math.max(0, px2 - px1);
        int oh = Math.max(0, py2 - py1);

        int answer;
        if (ow == 0 || oh == 0) {
            answer = w * h;         // 안 겹침
        } else if (ow == w && (py1 == rect1_y1 || py2 == rect1_y2)) {
            answer = w * (h - oh);  // 수평
        } else if (oh == h && (px1 == rect1_x1 || px2 == rect1_x2)) {
            answer = h * (w - ow);  // 수직
        } else {
            answer = w * h;         // 일부
        }
        System.out.println(answer);
    }
}