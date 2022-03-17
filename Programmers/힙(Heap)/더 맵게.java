import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Integer[] scov = Arrays.stream(scoville).boxed().toArray(Integer[]::new);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(scov));
        
        int answer = 0;
        int tmp=0;
        while (true) {
            if(pq.peek() >= K) break;
            if(pq.size() <=1) return -1;
            tmp = pq.poll();
            tmp += pq.poll() * 2;
            pq.add(tmp);
            answer++;
        }
        
        return answer;
    }
}