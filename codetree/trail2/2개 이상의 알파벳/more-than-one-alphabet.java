import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String result = "No";
        char c = A.charAt(0);
        for (char cc : A.toCharArray()) {
            if (cc != c) {
                result = "Yes";
                break;
            }
        }
        System.out.println(result);
    }
}