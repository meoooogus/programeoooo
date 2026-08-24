import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        System.out.println(judge(a, b));
    }
    private static String judge(int[] A, int[] B) {
        for (int i = 0; i + B.length <= A.length; i++) {
            int cur = i;
            int idx;
            for (idx = 0; idx < B.length; idx++) {
                if (B[idx] != A[cur++]) {
                    break;
                }
            }
            if (idx == B.length)
                return "Yes";
        }
        return "No";
    }
}