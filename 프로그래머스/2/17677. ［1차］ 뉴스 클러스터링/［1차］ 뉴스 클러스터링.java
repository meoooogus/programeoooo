import java.util.*;

class Solution {
    private static Map<String, Integer> map1 = new HashMap<>();
    private static Map<String, Integer> map2 = new HashMap<>();
    
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        setMap(map1, str1);
        setMap(map2, str2);
        
        if (map1.isEmpty() && map2.isEmpty())
            return 65536;
        int inter = 0;
        int union = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                inter += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key))
                union += map2.get(key);
        }
        double result = (double) inter / union * 65536;
        return (int) result;
    }
    
    private void setMap(Map<String, Integer> map, String str) {
        for (int idx = 0; idx + 1 < str.length(); idx++) {
            String cur = str.substring(idx, idx + 2);
            if (!cur.matches("[a-z]+"))
                continue;
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
    }
}