import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        Arrays.sort(mats);
        int w = park[0].length;
        int h = park.length;
        for (int k = mats.length-1; k >= 0; k--) {
            int mat = mats[k];
            
            for (int i = 0; i + mat <= h; i++) {
                for (int j = 0; j + mat <= w; j++)
                    if (canPlace(park, i, j, mat))
                        return mat;
            }
        }
        return -1;
    }
    
    private boolean canPlace(String[][] park, int x, int y, int mat) {
        for (int i = x; i < x + mat; i++) {
            for (int j = y; j < y + mat; j++)
                if (park[i][j].equals("-1") == false)
                    return false;
        }
        return true;
    }
}