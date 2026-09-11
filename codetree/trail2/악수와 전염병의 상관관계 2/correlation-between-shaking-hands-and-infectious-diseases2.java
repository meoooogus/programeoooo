import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();   // 전염 악수 횟수
        int P = sc.nextInt();   // 초기 감염자 번호
        int T = sc.nextInt();   // 악수 기록 개수
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt();    // 초
            shakes[i][1] = sc.nextInt();
            shakes[i][2] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(shakes, (a, b) -> a[0] - b[0]);
        int[] infection = new int[N];
        int[] count = new int[N];
        infection[P-1] = 1;
        count[P-1] = K;

        for (int i = 0; i < T; i++) {
            int p1 = shakes[i][1];
            int p2 = shakes[i][2];
            if (infection[p1-1] == 1 && infection[p2-1] == 1) {
                count[p1-1]--; count[p2-1]--;
            } else if (infection[p1-1] == 1 && count[p1-1] > 0 && infection[p2-1] == 0) {
                count[p1-1]--;
                infection[p2-1] = 1; count[p2-1] = K;
            } else if (infection[p1-1] == 0 && infection[p2-1] == 1 && count[p2-1] > 0) {
                count[p2-1]--;
                infection[p1-1] = 1; count[p1-1] = K;
            }
        }
        print(infection);
    }
    private static void print(int[] infection) {
        StringBuilder sb = new StringBuilder();
        for (int i : infection)
            sb.append(i);
        System.out.println(sb);
    }
}