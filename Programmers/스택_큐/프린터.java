import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> wait = new LinkedList<>();
        for(int i=0;i<priorities.length;i++) {
            queue.add(priorities[i]);
            wait.add(i);
        }
        int now; int answer = 0;
        while(!wait.isEmpty()){
            now = wait.poll();
            if(priorities[now]!=queue.peek()) wait.add(now);
            else{
                answer++;
                queue.poll();
                if(now==location) return answer;
            }
        }
        return answer;
    }
}