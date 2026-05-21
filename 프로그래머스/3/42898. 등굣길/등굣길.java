import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] grid = new int[n+1][m+1];
        for (int[] coord : puddles) {
            grid[coord[1]][coord[0]] = -1;
        }
        grid[1][1] = 1;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                if (x == 1 && y == 1) continue;
                
                if (grid[x][y] == -1) {
                    grid[x][y] = 0;
                    continue;
                }
    
                grid[x][y] = (grid[x-1][y] + grid[x][y-1]) % 1000000007;
            }
        }
        
        return grid[n][m];
    }
}

