import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(gcd(sc.nextInt(), sc.nextInt()));
    }
    private static int gcd(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }
}