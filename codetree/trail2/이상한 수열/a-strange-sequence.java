import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(recursion(n));
    }
    private static int recursion(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return recursion(n / 3) + recursion(n - 1);
    }
}