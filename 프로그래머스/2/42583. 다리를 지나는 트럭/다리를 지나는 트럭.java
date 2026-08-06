import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        for (int truck : truck_weights) trucks.offer(truck);
        for (int i = 0; i < bridge_length; i++) bridge.offer(0);
        int time = 0;
        int sum = 0;
        while (!trucks.isEmpty() || sum > 0) {
            time++;
            sum -= bridge.poll();
            if (!trucks.isEmpty() && trucks.peek() + sum <= weight) {
                int truck = trucks.poll();
                bridge.offer(truck);
                sum += truck;
            } else {
                bridge.offer(0);    // 빈 공간으로 처리
            }
        }
        
        return time;
    }
}