import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

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
        int cursor = 0;
        List<Character> list = new LinkedList<>();
        char c;
        for (int i = 0; i < input.length(); i++) {
            switch (c = input.charAt(i)) {
                case '<' :
                    if (cursor > 0)
                        cursor--;
                    break;
                case '>' :
                    if (cursor < list.size())
                        cursor++;
                    break;
                case '-' : // 리스트의 길이가 1 이상이면서, 커서가 1 이상일 때 커서-1번 인덱스를 삭제, 커서--
                    if (list.size() > 0 && cursor > 0) {
                        list.remove(cursor-1);
                        cursor--;
                    }
                    break;
                default:
                    list.add(cursor, c);
                    cursor++;
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
