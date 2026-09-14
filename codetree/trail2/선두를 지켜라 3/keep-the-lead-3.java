import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        int T = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            T += a[i][1];
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }
        // Please write your code here.
        
        int[] posA = new int[T + 1];
        int[] posB = new int[T + 1];

        int time = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i][1]; j++) {
                posA[++time] = (cur += a[i][0]); 
            }
        }
        time = 0; cur = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < b[i][1]; j++) {
                posB[++time] = (cur += b[i][0]); 
            }
        }
        int count = 0;
        int head = 0;
        for (int i = 1; i <= T; i++) {
            int prev = head;
            if (posA[i] < posB[i]) {
                head = -1;
            } else if (posA[i] > posB[i]) {
                head = 1;
            } else {
                head = 0;
            }
            if (prev != head) count++;
        }
        System.out.println(count);
    }
}