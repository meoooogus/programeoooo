import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.
        int min = Integer.MAX_VALUE;
        int skip = 1;
        int t = n - 2;
        while (t-- > 0) {
            int prev = 0;
            int dist = 0;
            for (int i = 1; i < n; i++) {
                if (i != skip) {
                    dist += Math.abs(x[prev] - x[i]) + Math.abs(y[prev] - y[i]);
                    prev = i;
                }
            }
            if (dist < min) min = dist;
            skip++;
        }
        System.out.println(min);
    }
}