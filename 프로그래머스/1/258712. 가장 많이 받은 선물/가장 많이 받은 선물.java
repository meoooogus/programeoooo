import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> nameIdx = new HashMap<>();
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
                int cmpHis = compareHistory(i, j, history);
                if (cmpHis == 1) receive[i]++;
                else if (cmpHis == -1) receive[j]++;
                else {
                    int cmpMet = compareMetric(i, j, metric);
                    if (cmpMet == 1) receive[i]++;
                    else if (cmpMet == -1) receive[j]++;
                }
            }
        }
        
        return Arrays.stream(receive).max().getAsInt();
    }
    
    private int compareHistory(int i, int j, int[][] history) {
        return history[i][j] > history[j][i] ? 1 : history[i][j] < history[j][i] ? -1 : 0;
    }
    
    private int compareMetric(int i, int j, int[] metric) {
        return metric[i] > metric[j] ? 1 : metric[i] < metric[j] ? -1 : 0;
    }
}