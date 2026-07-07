import java.util.*;

/*
 * [초기 풀이에 대한 효율성 문제]
 *
 * 1. DFS 수행 중 덩어리에 포함된 열(HashSet)까지 함께 관리
 *    -> 탐색과 정답 계산이 섞여 HashSet 관리 비용이 커짐.
 *
 * 2. 재귀 DFS 사용
 *    -> 최대 500x500 입력에서 StackOverflowError(런타임 에러) 발생 가능.
 *
 * [개선]
 *
 * 1. DFS는 덩어리 번호 부여와 크기 계산만 수행
 *    -> 탐색과 정답 계산을 분리하여 성능 개선.
 *
 * 2. 재귀 DFS 대신 스택을 이용한 반복 DFS 사용
 *    -> 호출 스택 한계를 피하여 큰 입력에서도 안정적으로 동작.
 */

class Solution {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] blockIdx;
    private static int size;
    private static int n;
    private static int m;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        int[] answer = new int[m];
        blockIdx = new int[n][m];
        int idx = 1;
        Map<Integer, Integer> sizes = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && blockIdx[i][j] == 0) {
                    size = 0;
                    dfs(i, j, land, idx);
                    sizes.put(idx, size);
                    idx++;
                }
            }
        }
        
        boolean[] seen = new boolean[idx];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (blockIdx[j][i] != 0 && seen[blockIdx[j][i]] == false) {
                    sum += sizes.get(blockIdx[j][i]);
                    seen[blockIdx[j][i]] = true;
                }
            }
            max = sum > max ? sum : max;
            Arrays.fill(seen, false);
            sum = 0;
        }
        return max;
    }
    
    private static void dfs(int r, int c, int[][] land, int idx) {
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {r, c});
        blockIdx[r][c] = idx;
        size++;
        
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                if (blockIdx[nr][nc] != 0)
                    continue;
                if (land[nr][nc] == 0)
                    continue;

                blockIdx[nr][nc] = idx;
                stk.push(new int[] {nr, nc});
                size++;
            }   
        }
    }
}
