import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static char[] d = new char[1000];
    public static int[] t = new int[1000];
    public static char[] d2 = new char[1000];
    public static int[] t2 = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            d[i] = sc.next().charAt(0);
            t[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            d2[i] = sc.next().charAt(0);
            t2[i] = sc.nextInt();
        }

        // Please write your code here.
        ArrayList<Character> cmdA = new ArrayList<>();
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < t[i]; j++) {
                cmdA.add(d[i]);
            }
        }
        ArrayList<Character> cmdB = new ArrayList<>();
        for (int i = 0; i < d2.length; i++) {
            for (int j = 0; j < t2[i]; j++) {
                cmdB.add(d2[i]);
            }
        }
        int totalTime = 0;
        int answer = -1;
        int curA = 0, curB = 0;
        for (int time : t) totalTime += time;
        for (int i = 0; i < totalTime; i++) {
            if (cmdA.get(i) == 'L') curA--;
            else if (cmdA.get(i) == 'R') curA++;

            if (cmdB.get(i) == 'L') curB--;
            else if (cmdB.get(i) == 'R') curB++;

            if (curA == curB) {
                answer = i + 1;
                break;
            }
        }
        System.out.println(answer);
    }
}
