import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(f(n));
    }
    private static String f(int n) {
        int a = n / 10; int b = n % 10;
        if (n % 2 != 0 || (a + b) % 5 != 0) return "No";
        return "Yes";
    }
}