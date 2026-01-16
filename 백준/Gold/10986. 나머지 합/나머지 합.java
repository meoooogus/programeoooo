import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        long[] longArr = new long[N];
        for (int i = 0; i < N; i++) {
            longArr[i] = scanner.nextInt();
        }
        long[] sumArr = new long[N];
        sumArr[0] = longArr[0];
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i-1] + longArr[i];
        }
        long[] mArr = new long[N];
        for (int i = 0; i < N; i++) {
            mArr[i] = sumArr[i] % M;
        }

        long idxCount = 0;
        long[] count = new long[M];
        for (long i : mArr) {
            if (i == 0)
                idxCount++;
            count[(int)i]++;
        }

        for (long i : count) {
            if (i > 0)
                idxCount = idxCount + (i * (i-1) / 2);
        }
        System.out.println(idxCount);
    }
}
