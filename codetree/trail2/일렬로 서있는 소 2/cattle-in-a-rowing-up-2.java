import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            int ii = arr[i];
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] >= ii) {
                    int jj = arr[j];
                    for (int k = j + 1; k < n; k++) {
                        if (arr[k] >= jj) result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}