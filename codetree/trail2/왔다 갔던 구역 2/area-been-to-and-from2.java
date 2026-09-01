import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<int[]> parts = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            int prev = cur;
            if (dir == 'L') {
                cur -= x;
                parts.add(new int[]{cur + 1000, prev + 1000});
            } else {
                cur += x;
                parts.add(new int[]{prev + 1000, cur + 1000});
            }
        }
        int[] count = new int[2001];
        for (int[] part : parts) {
            for (int i = part[0]; i <= part[1] - 1; i++) {
                count[i]++;
            }
        }
        System.out.println(getAnswer(count, 2001));
    }
    private static int getAnswer(int[] arr, int n) {
        int answer = 0;
        for (int val : arr)
            if (val >= 2)
                answer++;
        return answer;
    }
}