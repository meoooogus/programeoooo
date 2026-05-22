class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        int[] periods = new int[signals.length];
        int idx = 0;
        for (int[] a : signals) {
            periods[idx++] = a[0] + a[1] + a[2];
        }
        int total = periods[0];
        for (int i = 1; i < periods.length; i++) {
            total = lcm(total, periods[i]);
        }
        
        for (int t = 0; t < total; t++) {
            boolean check = true;
            
            for (int[] s : signals) {
                int green = s[0];
                int yellow = s[1];
                int red = s[2];
                
                int cycle = green + yellow + red;
                int cur = t % cycle;
                if (!(green <= cur && cur < green + yellow)) {
                    check = false;
                    break;
                }
            }
            
            if (check == true) {
                return t+1;
            }
            
        }
        
        return -1;
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int lcm (int a, int b) {
        return a / gcd(a, b) * b;
    }
}

// 각 주기 7 7 4
// 28?
