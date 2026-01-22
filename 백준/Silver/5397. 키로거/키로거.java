import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Main {
    //<<BP<A>>Cd-
    //BAPCd
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            sb.append(editor(input) + "\n");
        }
        System.out.println(sb);
    }

    public static String editor(String input) {
        List<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();
        char c;
        for (int i = 0; i < input.length(); i++) {
            switch (c = input.charAt(i)) {
                case '<' :
                    if (iter.hasPrevious())
                        iter.previous();
                    break;
                case '>' :
                    if (iter.hasNext())
                        iter.next();
                    break;
                case '-' :
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                default:
                    iter.add(c);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }
}
