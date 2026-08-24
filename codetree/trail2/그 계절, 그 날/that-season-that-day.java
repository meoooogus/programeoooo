import java.util.Scanner;
public class Main {
    private static int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        if (yn(y)) days[1]++;
        if (d > days[m-1])
            System.out.println(-1);
        else {
            System.out.println(season(m));
        }
    }
    private static boolean yn(int y) {
        if (y % 100 == 0) {
            if (y % 400 == 0)
                return true;
            else
                return false;
        }
        if (y % 4 == 0)
            return true;
        return false;
    }
    private static String season(int m) {
        switch (m) {
            case 3: case 4: case 5: return "Spring";
            case 6: case 7: case 8: return "Summer";
            case 9: case 10: case 11: return "Fall";
            case 12: case 1: case 2: return "Winter";
        }
        return "-1";
    }
}