import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static final int MAX_TIME = 2_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] posA = new int[MAX_TIME + 1];
        int cur = 0, timeA = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            for (int j = 0; j < t; j++) {
                if (d == 'L') {
                    posA[++timeA] = --cur;
                } else {
                    posA[++timeA] = ++cur;
                }
            }
        }
        Arrays.fill(posA, timeA + 1, MAX_TIME + 1, cur);

        int[] posB = new int[MAX_TIME + 1];
        cur = 0;
        int timeB = 0;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            for (int j = 0; j < t; j++) {
                if (d == 'L') {
                    posB[++timeB] = --cur;
                } else {
                    posB[++timeB] = ++cur;
                }
            }
        }
        Arrays.fill(posB, timeB + 1, MAX_TIME + 1, cur);
        // Please write your code here.
        int answer = 0;
        for (int i = 1; i <= Math.max(timeA, timeB); i++) {
            if (posA[i-1] != posB[i-1] && posA[i] == posB[i]) answer++;
        }
        System.out.println(answer);
    }
}