import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(recursion(arr, 0, n));
    }
    private static int recursion(int[] arr, int idx, int n) {
        if (idx == n) return arr[idx-1];
        int val = recursion(arr, idx+1, n);
        return val > arr[idx] ? val : arr[idx];
    }
}