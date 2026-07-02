import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> nameIdx = new HashMap<>();    // 이름 인덱스화
        for (int i = 0; i < friends.length; i++)
            nameIdx.put(friends[i], i);
        
        int[][] history = new int[friends.length][friends.length];
        int[] metric = new int[friends.length];
        
        for (String senderAndReceiver : gifts) {
            String[] sr = senderAndReceiver.split(" ");
            int si = nameIdx.get(sr[0]);
            int ri = nameIdx.get(sr[1]);
            
            history[si][ri]++;
            metric[si]++;
            metric[ri]--;
        }
        
        return nextMonth(history, metric, friends);
    }
    
    private int nextMonth(int[][] history, int[] metric, String[] friends) {
        int n = friends.length;
        int[] receive = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j)
                    continue;
                int cmp = Integer.compare(history[i][j], history[j][i]);
                if (cmp == 0) cmp = Integer.compare(metric[i], metric[j]);
                if (cmp > 0) receive[i]++;
                else if (cmp < 0) receive[j]++;
            }
        }
        
        return Arrays.stream(receive).max().getAsInt();
    }
}
