import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result;
        StringTokenizer st;
        for (int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            while(i != j) {
                if (i < j)
                    j /= 2;
                else if (i > j)
                    i /= 2;
            }
            result = 10 * i;
            System.out.println(result);
        }
    }
}
