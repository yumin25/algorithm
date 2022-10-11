import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> list = new ArrayList<>();
        int answer = 0;
        if(cacheSize<=0) return 5*cities.length;
        for(String s:cities){
            s = s.toUpperCase();
            if(list.contains(s)) {
                list.remove(s);
                answer += 1;
            }
            else {
                answer+=5;
                if(list.size()==cacheSize)list.remove(0);
            }
            list.add(s);
        }
        return answer;
    }
}