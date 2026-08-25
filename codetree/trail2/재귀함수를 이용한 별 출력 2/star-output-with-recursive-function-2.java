import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        decreaseStar(n);
        increaseStar(1, n);
    }
    private static void increaseStar(int cur, int n) {
        if (cur > n) return;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cur; i++) sb.append("* ");
        System.out.println(sb);
        increaseStar(++cur, n);
    }
    private static void decreaseStar(int n) {
        if (n == 0) return;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("* ");
        System.out.println(sb);
        decreaseStar(--n);
    }
}