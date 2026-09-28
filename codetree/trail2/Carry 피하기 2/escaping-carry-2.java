import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int max = -1;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (!hasCarry(arr[i], arr[j], arr[k])) {
                        if (arr[i] + arr[j] + arr[k] > max) {
                            max = arr[i] + arr[j] + arr[k];
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    static boolean hasCarry(int a, int b, int c) {
        while (a > 0 || b > 0 || c > 0) {
            if (a % 10 + b % 10 + c % 10 >= 10) {
                return true;
            }
            a /= 10; b /= 10; c /= 10;
        }
        return false;
    }
}