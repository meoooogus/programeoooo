import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String[]> splits = new ArrayList<>();
        for (String file : files) {
            splits.add(splitStr(file));
        }
        Integer[] idx = new Integer[files.length];
        for (int i = 0; i < idx.length; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> compareFileName(splits.get(a), splits.get(b)));
        
        String[] answer = new String[files.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = files[idx[i]];
        }
        return answer;
    }
 
    private String[] splitStr(String str) {
        int idx = 0;
        while (idx < str.length() && !Character.isDigit(str.charAt(idx)))
            idx++;
        String head = str.substring(0, idx).toLowerCase();
        StringBuilder number = new StringBuilder();
        for (int i = idx, cnt = 0; i < str.length() && cnt < 5; i++, cnt++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) number.append(c);
            else break;
        }
        return new String[] {head, number.toString()};
    }
    
    private int compareFileName(String[] f1, String[] f2) {
        int result = f1[0].compareTo(f2[0]);
        if (result != 0) return result;
        return Integer.compare(Integer.parseInt(f1[1]), Integer.parseInt(f2[1]));
    }
}