import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            queue.offer(i+1);
        }
        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
// 1 2 3 4