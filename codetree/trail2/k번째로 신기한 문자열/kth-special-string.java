import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        ArrayList<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith(t))
                wordList.add(word);
        }
        Collections.sort(wordList);
        System.out.println(wordList.get(k - 1));
    }
}