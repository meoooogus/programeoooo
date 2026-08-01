import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String convert = Integer.toString(n, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < convert.length(); i++) {
            char c = convert.charAt(i);
            if (c != '0') {
                sb.append(c);
            } else if (sb.length() > 0) {
                if (isPrime(Long.parseLong(sb.toString()))) answer++;
                sb.setLength(0);
            }
        }
        if (sb.length() > 0 && isPrime(Long.parseLong(sb.toString()))) answer++;
        return answer;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; (long) i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}