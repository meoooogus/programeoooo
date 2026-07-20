import java.util.*;

class Solution {
    private static Set<String> visited = new HashSet<>();
    private static int x = 0;
    private static int y = 0;
    public int solution(String dirs) {
        char[] chars = dirs.toCharArray();
        for (char c : chars)
            go(c);
        
        return visited.size() / 2;
    }   
    
    private void go(char cmd) {
        int nx = x;
        int ny = y;
        switch (cmd) {
            case 'U':
                if (y < 5) {
                    ny++;
                    addstr(nx, ny);
                }
                break;
            case 'D':
                if (y > -5) {
                    ny--;
                    addstr(nx, ny);
                }
                break;
            case 'R':
                if (x < 5) {
                    nx++;
                    addstr(nx, ny);
                }
                break;
            case 'L':
                if (x > -5) {
                    nx--;
                    addstr(nx, ny);
                }
                break;
        }
        x = nx; y = ny;
    }
    private void addstr(int nx, int ny) {
        visited.add(x + "," + y + "," + nx + "," + ny);
        visited.add(nx + "," + ny + "," + x + "," + y);
    }
}