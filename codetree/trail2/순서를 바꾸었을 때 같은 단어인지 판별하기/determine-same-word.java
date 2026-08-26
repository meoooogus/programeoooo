import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        System.out.println(judge(word1, word2));
    }
    private static String judge(String word1, String word2) {
        if (word1.length() != word2.length())
            return "No";
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Arrays.sort(chars1); Arrays.sort(chars2);
        String sortedWord1 = new String(chars1);
        String sortedWord2 = new String(chars2);
        return sortedWord1.equals(sortedWord2) ? "Yes" : "No";
    }
}