import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(lcm(arr, n));
    }
    private static int lcm(int[] arr, int n) {
        if (n == 1) return arr[0];
        if (n == 2) return arr[0] * arr[1] / gcd(arr[0], arr[1]);
        int a = arr[n-1], b = lcm(arr, n-1);
        return a * b / gcd (a, b);
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}