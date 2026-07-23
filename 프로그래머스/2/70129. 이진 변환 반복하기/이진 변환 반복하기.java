class Solution {
    public int[] solution(String s) {
        int loop = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        while (!s.equals("1")) {
            loop++;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    sb.append("1");
                } else {
                    count++;
                }
            }
            s = Integer.toBinaryString(sb.length());
            sb.setLength(0);
        }
        
        return new int[] {loop, count};
    }
}