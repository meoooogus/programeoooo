import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(f(a, b));
    }
    private static int f(int a, int b) {
        int val = 1;
        for (int i = 0; i < b; i++)
            val *= a;
        return val;
    }
}