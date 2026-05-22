import java.util.*;

class Solution {
    static boolean[] visited;
    Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        char[] chs = numbers.toCharArray();
        visited = new boolean[numbers.length()];
        dfs(chs, "");
        
        return primes.size();
    }
    
    public void dfs(char[] chs, String cur) {
        if (!cur.equals("") && isPrime(Integer.parseInt(cur)))
            primes.add(Integer.parseInt(cur));
        
        for (int i = 0; i < chs.length; i++) {
            if (visited[i] == true)
                continue;
            visited[i] = true;
            dfs(chs, cur + chs[i]);
            visited[i] = false;
        }
    }    
    public boolean isPrime(int n) {
        if (n < 2)
            return false;
        
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        
        return true;
    }
}
