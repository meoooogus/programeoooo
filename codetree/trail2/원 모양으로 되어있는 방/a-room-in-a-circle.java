import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int dist = 0;
            int pos = i;
            for (int j = 0; j < n; j++) {
                dist += arr[pos] * j;
                pos = (pos + 1) % n;
            }
            if (dist < min) min = dist;
        }
        System.out.println(min);
    }
}