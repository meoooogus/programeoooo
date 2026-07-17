import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        int todayValue = convertDay(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int expireDayValue = convertDay(split[0]) + termMap.get(split[1]) * 28;

            if (expireDayValue <= todayValue) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int convertDay(String date) {
        String[] ymd = date.split("\\.");

        int y = Integer.parseInt(ymd[0]);
        int m = Integer.parseInt(ymd[1]);
        int d = Integer.parseInt(ymd[2]);

        return y * 12 * 28 + m * 28 + d;
    }
}