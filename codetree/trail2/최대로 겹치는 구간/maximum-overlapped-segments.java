import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + 100;
            x2[i] = sc.nextInt() + 100;
        }
        int[] arr = new int[201];
        for (int i = 0; i < n; i++) {
            for (int j = x1[i]; j <= x2[i] - 1; j++) {
                arr[j]++;
            }
        }
        System.out.println(getMax(arr, 201));
    }
    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}