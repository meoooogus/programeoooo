class Solution {
    private static int answer = 0;
    private static int N;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        dfs(numbers, 0, target, 0);
        return answer;
    }
    private static void dfs(int[] numbers, int cur, int target, int depth) {
        if (depth == N) {
            if (cur == target)
                answer++;
            return;
        }
        dfs(numbers, cur + numbers[depth], target, depth+1);
        dfs(numbers, cur - numbers[depth], target, depth+1);
    }
    
}