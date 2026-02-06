// mCn // n , m 순서
import java.util.*;
import java.io.*;
// 5C2
// 5*4/1*2
class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long result = 1;
            for (int j = 1; j <= N; j++) {
                result = result * (M-j+1) / j;
            }
            
            System.out.println(result);
        }
    }
}