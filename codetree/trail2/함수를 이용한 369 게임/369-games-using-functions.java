import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        // Please write your code here.
        int result = 0;
        for (int i = A; i <= B; i++) {
            if (f(i)) result++;
        }
        System.out.println(result);
    }
    private static boolean f(int n) {
        if (n % 3 == 0) return true;
        String str = String.valueOf(n);
        return str.contains("3") || str.contains("6") || str.contains("9");
    }
}