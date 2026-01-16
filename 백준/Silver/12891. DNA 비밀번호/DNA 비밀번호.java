import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken()); // 문자열 총 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        // A C G T
        // 0 1 2 3
        char[] data;
        data = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        int[] intArr = new int[4]; // 최소 갯수들
        for (int i = 0; i < 4; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        // GATA
        // G, A
        int[] check = new int[4];
        for (int i = 0; i < P; i++) {
            add(check, data[i]);
        }

        int start = 0;
        int end = P-1;
        // dna 마지막 인덱스 S-1
        int count = 0;

        while (end < S) {
            int i;
            for (i = 0; i < 4; i++) {
                if (check[i] < intArr[i])
                    break;
            }
            if (i == 4)
                count++;
            remove(check, data[start++]);
            if (end == S-1) break;
            add(check, data[++end]);
        }
        System.out.println(count);
    }

    public static void add(int[] check, char ch) {
        switch (ch) {
            case 'A' :
                check[0]++;
                break;
            case 'C' :
                check[1]++;
                break;
            case 'G' :
                check[2]++;
                break;
            case 'T' :
                check[3]++;
                break;
        }
    }
    public static void remove(int[] check, char ch) {
        switch (ch) {
            case 'A' :
                check[0]--;
                break;
            case 'C' :
                check[1]--;
                break;
            case 'G' :
                check[2]--;
                break;
            case 'T' :
                check[3]--;
                break;
        }
    }
}
