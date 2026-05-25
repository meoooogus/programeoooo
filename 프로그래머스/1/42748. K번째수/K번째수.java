import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        int i = 0;
        for (int[] command : commands) {
            int[] copy = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(copy);
            answer[i++] = copy[command[2] - 1];
        }
        return answer;
    }
}