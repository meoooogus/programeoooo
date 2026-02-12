import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(factorial(n));
    }

    static long factorial(long n) {
        if (n == 0)
            return 1;
        return factorial(n-1) * n;
    }
}
