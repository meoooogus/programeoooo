class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int op_start_sec = mmssToSec(op_start);
        int op_end_sec = mmssToSec(op_end);
        int len = mmssToSec(video_len);
        int pos_sec = mmssToSec(pos);

        for (String cmd : commands) {
            if (isOp(pos_sec, op_start_sec, op_end_sec))
                pos_sec = op_end_sec;
            switch (cmd) {
                case "next" :
                    pos_sec = next(pos_sec, op_start_sec, op_end_sec, len);
                    break;
                case "prev" :
                    pos_sec = prev(pos_sec);
                    break;       
            }
            if (isOp(pos_sec, op_start_sec, op_end_sec))
                pos_sec = op_end_sec;
        }
        int minute = pos_sec / 60;
        int sec = pos_sec % 60;
        
        return String.format("%02d:%02d", minute, sec);
    }
    
    private int mmssToSec(String mmss) {
        return (mmss.charAt(0) - '0') * 10 * 60 
            + (mmss.charAt(1) - '0') * 60 
            + (mmss.charAt(3) - '0') * 10 
            + (mmss.charAt(4) - '0');
    }
    
    private int next(int pos, int op_start, int op_end, int len) {
        pos += 10;
        if (pos > len)
            return len;
        if (isOp(pos, op_start, op_end))
            return op_end;
        
        return pos;
    }
    
    private int prev(int pos) {
        if (pos < 10)
            return 0;
        
        return pos - 10;
    }
    
    private boolean isOp(int pos, int op_start, int op_end) {
        return pos <= op_end && pos >= op_start;
    }
}