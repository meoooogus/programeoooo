import java.util.*;

class Solution {
    static Map<String, String> userMap = new HashMap<>();
    static List<String> answer = new ArrayList<>();
    public String[] solution(String[] record) {
        for (String log : record) {
            String[] s = log.split(" ");
            String cmd = s[0];
            switch (cmd) {
                case "Enter":
                    enter(s[1], s[2]);
                    break;
                case "Leave":
                    leave(s[1]);
                    break;
                case "Change":
                    setName(s[1], s[2]);
                    break;
            }
        }
        for (int i = 0; i < answer.size(); i++) {
            String[] s = answer.get(i).split(" ");
            if (s[1].equals("in")) {
                s[1] = "님이 들어왔습니다.";
            } else {
                s[1] = "님이 나갔습니다.";
            }
            answer.set(i, userMap.get(s[0]) + s[1]);
        }
        return answer.toArray(new String[0]);
    }
    
    private void enter(String uid, String name) {
        answer.add(uid + " in");
        setName(uid, name);
    }
    private void leave(String uid) {
        answer.add(uid + " out");
    }
    private void setName(String uid, String name) {
        userMap.put(uid, name);
    }
}