import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();
        }
        ArrayList<Integer> vA = new ArrayList<>();
        ArrayList<Integer> vB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < A[i][1]; j++)
                vA.add(A[i][0]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < B[i][1]; j++)
                vB.add(B[i][0]);
        }
        int curA = 0, curB = 0;
        int totalTime = 0;
        int status = 0; int prev = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) totalTime += A[i][1];
        for (int i = 0; i < totalTime; i++) {
            curA += vA.get(i); curB += vB.get(i);
            prev = status;
            if (curA < curB) status = -1;
            else if (curA > curB) status = 1;
            if (prev != status) answer++;
        }
        System.out.println(answer - 1);
    }
}