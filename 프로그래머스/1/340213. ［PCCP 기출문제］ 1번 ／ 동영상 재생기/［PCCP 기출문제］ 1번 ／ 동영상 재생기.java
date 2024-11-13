class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoMin = timeToMinutes(video_len);
        int posMin = timeToMinutes(pos);
        int opStartMin = timeToMinutes(op_start);
        int opEndMin = timeToMinutes(op_end);
        
        if (posMin >= opStartMin && posMin <= opEndMin) {
            posMin = opEndMin;
        }
        
        for (String command : commands) {
            if (command.equals("prev")) {
                posMin = Math.max(0, posMin - 10);
            } else if (command.equals("next")) {
                posMin = Math.min(videoMin, posMin + 10);
            }
            
            if (posMin >= opStartMin && posMin <= opEndMin) {
                posMin = opEndMin;
            }
        }
        
        return String.format("%02d:%02d", posMin / 60, posMin % 60);
    }
    
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}