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
        String[] ymd = date.split("\\.");    //split의 인자는 정규표현식을 사용하기 때문에 "."을 입력하면 아무 문자를 기준으로 나누게 됨 -> 이스케이프(\\)로 나누기

        int y = Integer.parseInt(ymd[0]);
        int m = Integer.parseInt(ymd[1]);
        int d = Integer.parseInt(ymd[2]);

        return y * 12 * 28 + m * 28 + d;
    }
}
