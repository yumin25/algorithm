import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        int now = 0;
        
        for(String ss:s){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            int sbCount = 0;
            for(int i=0;i<ss.length();i++){
                sbCount = sb.length();
                if(ss.charAt(i)=='0' && sbCount>1 && sb.charAt(sbCount-1)=='1' && sb.charAt(sbCount-2)=='1') {
                    count++;
                    sb.delete(sbCount-2, sbCount);
                }
                else sb.append(ss.charAt(i));
            }

            for(int k=0;k<count;k++){
                int index = sb.lastIndexOf("0");
                if(index != -1) sb.insert(index+1, "110");
                else sb.insert(0, "110");
            }
            answer[now++] = sb.toString();
        }
        
        return answer;
    }
}