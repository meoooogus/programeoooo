import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> names = new HashMap<>();
        List<String[]> events = new ArrayList<>(); // {"Enter"/"Leave", uid}

        for (String log : record) {
            String[] s = log.split(" ");
            if (!s[0].equals("Leave")) names.put(s[1], s[2]); // Enter, Change
            if (!s[0].equals("Change")) events.add(new String[] {s[0], s[1]}); // Enter, Leave
        }

        List<String> answer = new ArrayList<>();
        for (String[] e : events) {
            String msg = e[0].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
            answer.add(names.get(e[1]) + msg);
        }
        return answer.toArray(new String[0]);
    }
}
