import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] penalizedPerson = new int[m];
        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] students = new int[n + 1];
        int answer = -1;
        for (int i = 0; i < m; i++) {
            students[penalizedPerson[i]]++;
            if (students[penalizedPerson[i]] >= k) {
                answer = penalizedPerson[i];
                break;
            }
        }
        System.out.println(answer);
    }
}