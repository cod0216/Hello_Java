class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int videoTime = getTime(video_len);
        int now = getTime(pos);
        int opStartTime = getTime(op_start);
        int opEndTime = getTime(op_end);
        
        if(now >= opStartTime && now < opEndTime) now = opEndTime;
        
        
        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals("next")){
                now += 10;
            } else {
                now -= 10;
            } 
            
            if(now < 0) now = 0;
            if(now > videoTime) now = videoTime;
            if(now >= opStartTime && now < opEndTime) now = opEndTime;
            
        }
        int hour = now / 60;
        int min = now%60;
        
        return getHour(hour) + ":" + getMin(min);
        
    }
    
    public static String getHour(int h){
        StringBuilder sb = new StringBuilder();
        if(10 > h) sb.append("0");
        
        sb.append(h);
        return sb.toString();
    }
    
    public static String getMin(int m){
        if(m == 0) return "00";
        if(10 > m) return "0"+m;
        
        StringBuilder sb = new StringBuilder();
        sb.append(m);
        return sb.toString();
    }
    
    public static int getTime(String str) {
        String[] input = str.split(":");
        int a = 60 * Integer.parseInt(input[0]);
        int t = a + Integer.parseInt(input[1]);
        
        return t;
    }
}