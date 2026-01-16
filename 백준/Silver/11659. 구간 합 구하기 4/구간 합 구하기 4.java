import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        int[] intArr = new int[N];
        for (int i = 0; i < N; i++) {
            intArr[i] = scanner.nextInt();
        }

        int[] sumArr = new int[N+1];
        sumArr[0] = 0;
        for (int i = 1; i < N+1; i++) {
            sumArr[i] = sumArr[i-1] + intArr[i-1];
        }

        int i, j;
        for (int k = 0; k < M; k++) {
            i = scanner.nextInt();
            j = scanner.nextInt();
            System.out.println(sumArr[j] - sumArr[i-1]);
        }

    }
}
