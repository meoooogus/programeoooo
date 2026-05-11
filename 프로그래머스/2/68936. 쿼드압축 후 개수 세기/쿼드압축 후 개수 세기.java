class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        answer = new int[2];
        compress(arr, answer, 0, 0, arr.length);
        return answer;
    }
    
    public void compress(int[][] arr, int answer[], int x, int y, int size) {
        if (isDiff(arr, x, y, size)){
            answer[arr[x][y]]++;
            return;
        }
        
        int half = size / 2;
        compress(arr, answer, x, y, half);
        compress(arr, answer, x + half, y, half);
        compress(arr, answer, x, y + half, half);
        compress(arr, answer, x + half, y + half, half);
    }
    
    public boolean isDiff(int[][] arr, int x, int y, int size){
        int cmp = arr[x][y];
        for (int i = x; i < x + size; i++){
            for (int j = y; j < y + size; j++) {
                if (cmp != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}