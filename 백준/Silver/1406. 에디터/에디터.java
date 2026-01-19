import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        LinkedList<Character> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // a b c d
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            list.add(chars[i]);
        }
        ListIterator<Character> it = list.listIterator(list.size());
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            switch (token) {
                case "L" :
                    if (it.hasPrevious())
                        it.previous();
                    break;
                case "D" :
                    if (it.hasNext())
                        it.next();
                    break;
                case "B" :
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case "P" :
                    char c = st.nextToken().charAt(0);
                    it.add(c);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
