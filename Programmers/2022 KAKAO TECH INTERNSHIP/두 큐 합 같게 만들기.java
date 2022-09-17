import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        int answer = 0; int tmp=0; int len = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0;i<len;i++){   //합 구하기 및 큐에 데이터 삽입
            sum1 += queue1[i];
            q1.add(queue1[i]);
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }
        
        while(sum1!=sum2){
           // System.out.println(Math.pow(2,len));
            //if(answer>len*3){Math.pow(2,5); 
            if(answer>Math.pow(2,len)){
                answer=-1;
                break;
            }
            answer++;
            if(sum1<sum2){
                tmp = q2.poll();
                q1.add(tmp);
                sum1 += tmp;
                sum2 -= tmp;
            }
            else{
                tmp = q1.poll();
                q2.add(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            }
        }        
        return answer;
    }
}