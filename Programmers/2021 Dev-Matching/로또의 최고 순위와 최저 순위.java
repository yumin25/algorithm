import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroNum = 0, match = 0;
        for(int i:lottos){
            if(i==0) zeroNum++;
            if(Arrays.stream(win_nums).anyMatch(s -> s ==i)) match++;
        }
        
        if(match<2) answer[1]=6;
        else answer[1]=7-match;
        
        match += zeroNum;
        if(match<2) answer[0]=6;
       else answer[0]=7-match;
        return answer;
    }
}